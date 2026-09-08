# Java Deep Accuracy Benchmark

Benchmark controlado e reproduzível para medir **qualidade e acurácia de SAST em Java**, criado para apoiar o refinamento das rules do XGuardian com métricas objetivas e ground truth conhecido.

O objetivo central é responder:

> **Depois de alterar uma rule, o scanner realmente ficou melhor — ou apenas passou a detectar mais coisas e gerar mais ruído?**

O projeto mede **TP, TN, FP, FN, Precision, Recall, FPR, F1, Accuracy, Balanced Accuracy, MCC, taxonomia CWE, duplicidade, extraneous findings e regressões**, com visão por **CWE, dificuldade, framework, dataflow e holdout**.

---

## Uso rápido

Se você só precisa executar o benchmark no XGuardian, siga este fluxo:

### 1. Scaneie somente

~~~text
scan-target/
~~~

> [!CAUTION]
> **Não scaneie o repositório inteiro.**
>
> Pastas como `ground-truth/`, `docs/`, `corpus/` e `tools/` contêm respostas esperadas, nomes de CWE e informações que podem contaminar o teste.

### 2. Exporte o resultado SAST em JSON

Exemplo:

~~~text
results/raw/xguardian-run-001.json
~~~

### 3. Calcule a acurácia

~~~bash
python tools/evaluate_xguardian.py \
  results/raw/xguardian-run-001.json \
  --ground-truth ground-truth/ground_truth.json \
  --out results/run-001
~~~

### 4. Depois de alterar uma rule, rode novamente e compare

~~~bash
python tools/compare_runs.py \
  results/run-before/score.json \
  results/run-after/score.json \
  --out results/comparison
~~~

A comparação mostra se a alteração:

- corrigiu falsos negativos;
- reduziu falsos positivos;
- criou novos falsos negativos;
- criou novos falsos positivos;
- melhorou ou piorou o holdout;
- mudou a classificação CWE;
- aumentou duplicidade;
- causou regressão em outras CWEs.

---

# 1. O que existe neste benchmark

| Dimensão | Quantidade |
|---|---:|
| Casos Java pontuados | **600** |
| Vulneráveis intencionais | **300** |
| Seguros / hard-negatives | **300** |
| CWEs | **30** |
| Casos por CWE | **20** |
| Vulneráveis por CWE | **10** |
| Seguros por CWE | **10** |
| Níveis de dificuldade | **5** |
| Casos por nível | **120** |
| Development set | **450** |
| Holdout | **150** |
| Java alvo | **17** |

Cada arquivo pontuado possui nome neutro:

~~~text
Case000001.java
Case000002.java
...
Case000600.java
~~~

O código enviado ao scanner não informa:

- se o caso é vulnerável;
- se o caso é seguro;
- qual CWE está sendo testada;
- se o resultado esperado é TP, TN, FP ou FN.

Essas informações ficam fora do payload, no ground truth.

---

# 2. O que exatamente deve ser escaneado

## Caminho oficial

~~~text
scan-target/
~~~

A estrutura enviada ao XGuardian deve ser equivalente a:

~~~text
scan-target/
└── io/
    └── xguardian/
        └── javabench/
            ├── cases/
            │   ├── level1/
            │   ├── level2/
            │   ├── level3/
            │   ├── level4/
            │   └── level5/
            └── support/
~~~

A pasta `support/` também faz parte do payload. Alguns casos utilizam helpers compartilhados para representar controles reais, como:

- HTML escaping;
- validação de redirect;
- allowlist de host;
- validação de header;
- tratamento de filename;
- escaping de LDAP.

## Não envie ao SAST

~~~text
ground-truth/
corpus/
benchmark_meta/
docs/
tools/
tests/
build-harness/
results/
.github/
README.md
CONTRIBUTING.md
SECURITY.md
~~~

Essas áreas existem para avaliação, documentação, reprodução e manutenção do benchmark.

---

# 3. Como o benchmark funciona

Cada caso possui uma verdade conhecida antes do scan.

Exemplo conceitual de Command Injection:

## Vulnerável

~~~java
new ProcessBuilder(
    "sh",
    "-c",
    "echo " + input
).start();
~~~

O valor externo entra em um comando interpretado pelo shell.

## Hard-negative

~~~java
new ProcessBuilder(
    List.of("printf", "%s", input)
).start();
~~~

Aqui o executável é fixo e o valor é fornecido como argumento separado, sem shell.

O objetivo é descobrir se o scanner entende **contexto**, em vez de simplesmente reconhecer uma API considerada perigosa.

O mesmo princípio é usado em outras categorias:

| Categoria | Vulnerável | Hard-negative |
|---|---|---|
| SQL Injection | concatenação SQL | PreparedStatement |
| Path Traversal | path externo sem containment | normalize + containment |
| XSS | input em HTML sem encoding | output encoding / text context |
| SSRF | URL arbitrária | allowlist de scheme/host/port |
| XXE | parser default | DTD/entities/external access bloqueados |
| Deserialization | objeto arbitrário | filtro estrito / sem object deserialization |
| Sensitive Logging | credencial no logger | credencial fora do log |
| Cookie Secure | Secure ausente | Secure + HttpOnly |
| Cookie HttpOnly | HttpOnly ausente | Secure + HttpOnly |

---

# 4. TP, TN, FP e FN

Essas quatro classes são a base da avaliação.

| Ground truth | Scanner encontrou? | Resultado | Significado |
|---|---|---|---|
| Vulnerável | Sim | **TP** | Detectou corretamente |
| Vulnerável | Não | **FN** | Deixou vulnerabilidade passar |
| Seguro | Sim | **FP** | Gerou alerta indevido |
| Seguro | Não | **TN** | Reconheceu corretamente o caso seguro |

## TP — True Positive

O caso é vulnerável e o scanner encontra o problema.

**Resultado desejável.**

## FN — False Negative

O caso é vulnerável, mas o scanner não encontra.

É um problema de cobertura: uma vulnerabilidade real passou despercebida.

## FP — False Positive

O caso possui um controle de segurança conhecido, mas o scanner gera finding mesmo assim.

É um problema de precisão e ruído operacional.

Exemplo de hard-negative SQL:

~~~java
PreparedStatement statement =
    connection.prepareStatement(
        "SELECT * FROM users WHERE id = ?"
    );

statement.setString(1, input);
~~~

Se uma rule marcar a condição acima como SQL Injection, o benchmark registra FP.

## TN — True Negative

O caso é seguro para a CWE pontuada e o scanner corretamente não gera finding.

---

# 5. Métricas calculadas

## Recall / TPR

~~~text
TP / (TP + FN)
~~~

Responde:

> Das vulnerabilidades reais existentes no corpus, quantas foram encontradas?

Recall alto significa poucos FN.

## Precision

~~~text
TP / (TP + FP)
~~~

Responde:

> Dos casos acusados pelo scanner, quantos eram de fato vulneráveis?

Precision alta significa menos ruído.

## False Positive Rate

~~~text
FP / (FP + TN)
~~~

Responde:

> Entre os casos seguros, quantos foram acusados indevidamente?

Quanto menor, melhor.

## F1 Score

Combina Precision e Recall.

É útil porque uma rule pode aumentar Recall e, ao mesmo tempo, aumentar FP de forma excessiva.

## Accuracy

~~~text
(TP + TN) / (TP + TN + FP + FN)
~~~

Como o corpus é balanceado em 300 vulneráveis e 300 seguros, Accuracy é útil, mas **não deve ser analisada isoladamente**.

## Balanced Accuracy

Combina TPR e Specificity e ajuda a observar os dois lados da matriz de confusão.

## MCC

O Matthews Correlation Coefficient utiliza:

~~~text
TP
TN
FP
FN
~~~

É uma métrica complementar para qualidade global da classificação.

## OWASP-style score

O projeto também calcula:

~~~text
100 × (TPR - FPR)
~~~

A nomenclatura **OWASP-style** é proposital. O evaluator deste projeto não é apresentado como evaluator oficial da OWASP.

---

# 6. Detecção e classificação CWE são separadas

Um scanner pode encontrar o problema correto e classificá-lo com uma CWE diferente.

Por isso o benchmark separa:

## Detection Accuracy

> O scanner encontrou a vulnerabilidade na região esperada?

## Taxonomy Accuracy

> O scanner classificou a vulnerabilidade corretamente?

O ground truth possui:

~~~text
preferred_cwe
accepted_cwes
~~~

E o evaluator registra:

- `taxonomy_exact`;
- `taxonomy_accepted`.

Assim, erro de taxonomia não é tratado automaticamente como FN.

---

# 7. Os 5 níveis de dificuldade

O benchmark não contém somente exemplos triviais.

| Nível | Característica |
|---|---|
| **Level 1** | condição direta |
| **Level 2** | alias / variável intermediária |
| **Level 3** | helper / interprocedural |
| **Level 4** | framework ou configuração contextual |
| **Level 5** | Function, Supplier, wrapper ou indirection adicional |

## Level 1

~~~text
input
  ↓
sink
~~~

Valida cobertura básica.

## Level 2

~~~text
input
  ↓
variável intermediária
  ↓
sink
~~~

## Level 3

~~~text
input
  ↓
helper
  ↓
retorno
  ↓
sink
~~~

## Level 4

Inclui contextos mais próximos de aplicações Java reais, conforme a CWE:

- Jakarta Servlet;
- HTTP request/body;
- principal autenticado;
- JDBC;
- JAXP;
- JSSE;
- Java serialization;
- java.net.http;
- factories/configuration.

## Level 5

Introduz indirection adicional, como:

- Function;
- Supplier;
- wrappers;
- factories;
- predicates;
- abstrações intermediárias.

> Nem toda CWE é uma taint-flow vulnerability.
>
> Em TLS, crypto, cookies e outras CWEs de configuração, a dificuldade mede acompanhamento de **configuração e indirection**, e não apenas distância source → sink.

---

# 8. CWEs cobertas

| CWE | Categoria |
|---|---|
| CWE-22 | Path Traversal |
| CWE-78 | OS Command Injection |
| CWE-79 | Cross-Site Scripting |
| CWE-89 | SQL Injection |
| CWE-90 | LDAP Injection |
| CWE-94 | Code Injection |
| CWE-113 | HTTP Response Splitting |
| CWE-209 | Sensitive Error Message |
| CWE-295 | Certificate Validation |
| CWE-319 | Cleartext Transmission |
| CWE-321 | Hard-coded Cryptographic Key |
| CWE-327 | Broken/Risky Cryptography |
| CWE-328 | Weak Hash |
| CWE-330 | Insufficient Randomness |
| CWE-347 | Signature Verification |
| CWE-352 | CSRF |
| CWE-400 | Uncontrolled Resource Consumption |
| CWE-434 | Dangerous File Upload |
| CWE-470 | Unsafe Reflection |
| CWE-502 | Unsafe Deserialization |
| CWE-532 | Sensitive Logging |
| CWE-601 | Open Redirect |
| CWE-611 | XXE |
| CWE-614 | Cookie without Secure |
| CWE-643 | XPath Injection |
| CWE-798 | Hard-coded Credentials |
| CWE-862 | Missing Authorization |
| CWE-918 | SSRF |
| CWE-1004 | Cookie without HttpOnly |
| CWE-1333 | Inefficient Regular Expression / ReDoS |

Cada CWE possui documentação própria em:

~~~text
docs/cwe/
~~~

Catálogo completo:

[docs/CORPUS_CATALOG.md](docs/CORPUS_CATALOG.md)

---

# 9. Development set e Holdout

## Development

~~~text
450 casos
~~~

Pode ser usado durante:

- investigação;
- tuning;
- correção de FN;
- correção de FP;
- desenvolvimento de rules.

## Holdout

~~~text
150 casos
75 vulneráveis
75 seguros
30 por nível
~~~

O holdout existe para verificar **generalização**.

A pergunta é:

> A rule realmente ficou melhor ou apenas foi adaptada aos casos observados durante o desenvolvimento?

Uma mudança pode melhorar development e piorar holdout. Isso é sinal de possível overfitting.

> [!WARNING]
> Não escreva exceções baseadas em Case ID, strings específicas do benchmark ou estrutura conhecida de um fixture.
>
> A rule deve corrigir a classe semântica do problema.

Mais detalhes:

[docs/HOLDOUT_POLICY.md](docs/HOLDOUT_POLICY.md)

---

# 10. Como criar a primeira baseline

## Passo 1 — validar o corpus

~~~bash
python -m unittest discover -s tests -p "test_*.py" -v
python tools/validate_ground_truth.py
python tools/validate_cases.py
python corpus/generate_cases.py --check
mvn -q -f build-harness/pom.xml -DskipTests compile
~~~

A compilação valida os fixtures como Java 17, mas **não executa os caminhos vulneráveis**.

## Passo 2 — executar o scan

No XGuardian, utilize somente:

~~~text
scan-target/
~~~

Para rastreabilidade, registre:

~~~text
benchmark commit
engine/rules commit
scan ID
app ID
data/hora
configuração relevante
resultado JSON original
~~~

Não armazene tokens ou credenciais no repositório.

## Passo 3 — exportar o JSON

Exemplo:

~~~text
results/raw/xguardian-baseline.json
~~~

## Passo 4 — executar o evaluator

~~~bash
python tools/evaluate_xguardian.py \
  results/raw/xguardian-baseline.json \
  --ground-truth ground-truth/ground_truth.json \
  --out results/baseline
~~~

Saídas:

~~~text
results/baseline/
├── score.json
├── case_results.csv
├── findings_normalized.json
├── unmatched_findings.json
├── extraneous_findings.json
└── summary.md
~~~

---

# 11. Como testar uma alteração nas rules

## Antes

~~~text
rules commit A
    ↓
scan
    ↓
results/before/
~~~

## Depois

~~~text
rules commit B
    ↓
scan
    ↓
results/after/
~~~

Compare:

~~~bash
python tools/compare_runs.py \
  results/before/score.json \
  results/after/score.json \
  --out results/comparison
~~~

A comparação mostra:

~~~text
Fixed FP
New FP
Fixed FN
New FN

Recall delta
FPR delta
F1 delta
MCC delta
Taxonomy delta
Duplicate rate delta
~~~

## Exemplo de melhoria real

~~~text
ANTES
TP = 8
FN = 2
FP = 2
TN = 8

DEPOIS
TP = 10
FN = 0
FP = 1
TN = 9
~~~

Aqui:

- dois FN foram corrigidos;
- FP caiu;
- Recall melhorou;
- Precision melhorou.

## Exemplo de resultado que exige cuidado

~~~text
ANTES
TP = 8
FP = 2

DEPOIS
TP = 10
FP = 20
~~~

O scanner detectou mais vulnerabilidades, mas abriu muito ruído.

Quantidade de findings, sozinha, **não é acurácia**.

---

# 12. Normalização e deduplicação

Antes do scoring, findings são normalizados.

A chave lógica usada para deduplicação é:

~~~text
path + line + CWE
~~~

A linha é convertida para inteiro.

Assim:

~~~text
linha = 5
~~~

e:

~~~text
linha = "5"
~~~

não são tratados como findings diferentes.

O evaluator também informa:

- raw findings;
- normalized findings;
- duplicate findings;
- duplicate rate.

---

# 13. Extraneous e unmatched findings

## Extraneous finding

Finding em arquivo conhecido, mas fora da região pontuada.

Ele é preservado para investigação, mas não transforma silenciosamente o caso em TP ou FP.

## Unmatched finding

Finding cujo caminho não corresponde a nenhum caso conhecido no ground truth.

Arquivos correspondentes:

~~~text
extraneous_findings.json
unmatched_findings.json
~~~

---

# 14. Ground truth

A verdade oficial do benchmark está em:

~~~text
ground-truth/ground_truth.json
~~~

Cada caso contém campos como:

~~~json
{
  "id": "JAV-000001",
  "path": "scan-target/.../Case000001.java",
  "expected_vulnerable": true,
  "preferred_cwe": "CWE-22",
  "accepted_cwes": ["CWE-22"],
  "category": "Path Traversal",
  "difficulty": 1,
  "framework": "JDK",
  "source": "method_parameter",
  "sink": "java.nio.file.Files",
  "dataflow": "direct",
  "target_start_line": 10,
  "target_end_line": 12,
  "rationale": "...",
  "official_reference": "https://cwe.mitre.org/data/definitions/22.html",
  "cohort": "development"
}
~~~

## Regra crítica

O ground truth **não deve ser alterado apenas porque o scanner discordou**.

Qualquer mudança precisa de:

- referência técnica;
- revisão do código;
- rationale;
- revisão do par positivo/negativo;
- reexecução dos validadores.

Veja:

[docs/GROUND_TRUTH_POLICY.md](docs/GROUND_TRUTH_POLICY.md)

---

# 15. Base metodológica externa

Os 600 fixtures deste projeto são originais. A metodologia foi informada por benchmarks e instituições reconhecidas.

## OWASP Benchmark for Java

https://owasp.org/www-project-benchmark/

A documentação da versão Java 1.2 apresenta:

- **2.740 casos**;
- **11 áreas**;
- expected results conhecidos;
- avaliação de true/false positives.

O projeto usa essa filosofia como referência metodológica, sem copiar o corpus.

## NIST SARD / Juliet Java 1.3

https://samate.nist.gov/SARD/test-suites/111

O NIST informa:

- **28.881 casos Java**;
- **112 CWEs**;
- 73,2 MB;
- autoria do NSA Center for Assured Software.

## MITRE CWE

https://cwe.mitre.org/

O MITRE CWE é a **autoridade semântica primária** utilizada para decidir o significado das fraquezas do benchmark.

## GitHub CodeQL

https://codeql.github.com/codeql-query-help/java/

Usado como referência secundária para:

- sources;
- sinks;
- sanitizers;
- APIs;
- recomendações;
- padrões de análise.

## SonarSource

https://rules.sonarsource.com/java/

Usada como referência secundária de padrões Java/SAST.

Detalhes:

[docs/REFERENCES.md](docs/REFERENCES.md)

---

# 16. Estrutura do repositório

~~~text
.
├── README.md
├── SECURITY.md
├── CONTRIBUTING.md
├── LICENSE
│
├── scan-target/             # ÚNICA área a ser scaneada
│   └── io/xguardian/javabench/
│       ├── cases/
│       │   ├── level1/
│       │   ├── level2/
│       │   ├── level3/
│       │   ├── level4/
│       │   └── level5/
│       └── support/
│
├── ground-truth/            # resposta esperada; não scanear
├── corpus/                  # fonte determinística; não scanear
├── benchmark_meta/          # catálogo e referências
├── tools/                   # evaluator e validators
├── tests/                   # testes do tooling
├── build-harness/           # compile-only
├── docs/                    # documentação
├── results/                 # resultados locais
└── .github/workflows/       # CI
~~~

---

# 17. Quality gates

O projeto valida automaticamente:

## Estrutura

- 600 casos;
- 300 vulneráveis;
- 300 seguros;
- 30 CWEs;
- 20 casos por CWE;
- 120 por nível;
- development/holdout balanceados.

## Anti-leakage

Dentro de `scan-target/` não devem existir:

- nomes CWE;
- TP/TN/FP/FN;
- marcadores vulnerable/safe;
- ground truth;
- credenciais reais.

## Reprodutibilidade

~~~bash
python corpus/generate_cases.py --check
~~~

deve confirmar que o corpus materializado corresponde à definição canônica.

## Java

~~~bash
mvn -q -f build-harness/pom.xml -DskipTests compile
~~~

deve compilar todo o payload sem executar os casos.

## CI

O workflow:

~~~text
.github/workflows/benchmark-validation.yml
~~~

executa esses controles automaticamente em push e pull request.

---

# 18. Documentação

| Documento | Finalidade |
|---|---|
| [METHODOLOGY.md](docs/METHODOLOGY.md) | Como o benchmark foi desenhado |
| [SCORING.md](docs/SCORING.md) | Métricas e fórmulas |
| [XGUARDIAN_USAGE.md](docs/XGUARDIAN_USAGE.md) | Execução no XGuardian |
| [RULE_TUNING_GUIDE.md](docs/RULE_TUNING_GUIDE.md) | Como refinar rules |
| [GROUND_TRUTH_POLICY.md](docs/GROUND_TRUTH_POLICY.md) | Regras de ground truth |
| [HOLDOUT_POLICY.md](docs/HOLDOUT_POLICY.md) | Uso correto do holdout |
| [CASE_AUTHORING_GUIDE.md](docs/CASE_AUTHORING_GUIDE.md) | Como criar/revisar fixtures |
| [QUALITY_GATES.md](docs/QUALITY_GATES.md) | Gates de integridade |
| [EXTERNAL_VALIDATION.md](docs/EXTERNAL_VALIDATION.md) | OWASP / Juliet / validação independente |
| [KNOWN_LIMITATIONS.md](docs/KNOWN_LIMITATIONS.md) | Limitações conhecidas |
| [REPRODUCIBILITY.md](docs/REPRODUCIBILITY.md) | Reprodução do corpus |
| [CHANGE_CONTROL.md](docs/CHANGE_CONTROL.md) | Controle de mudanças |
| [INTERPRETATION.md](docs/INTERPRETATION.md) | Como interpretar métricas |
| [CORPUS_CATALOG.md](docs/CORPUS_CATALOG.md) | Catálogo das 30 CWEs |
| [REFERENCES.md](docs/REFERENCES.md) | Fontes externas |
| [BASELINE.md](docs/BASELINE.md) | Baseline XGuardian |
| [docs/cwe/](docs/cwe/) | Documentação individual por CWE |

---

# 19. Baseline atual

> [!NOTE]
> Ainda não existe uma baseline XGuardian oficial para este novo corpus de **600 casos**.

O primeiro scan completo de:

~~~text
scan-target/
~~~

deve ser tratado como a baseline inicial do Java Deep Accuracy Benchmark v1.

Somente depois do scan e da avaliação do JSON devem ser registrados:

- TP;
- TN;
- FP;
- FN;
- Precision;
- Recall;
- FPR;
- F1;
- Accuracy;
- MCC;
- Taxonomy;
- resultados por CWE;
- resultados por nível;
- development;
- holdout.

Resultados do benchmark Java anterior de 20 casos **não são diretamente comparáveis** a este corpus.

---

# 20. Como interpretar uma boa evolução

A regra central é:

> **Uma rule não ficou melhor apenas porque encontrou mais findings.**

Idealmente, uma evolução tende a:

~~~text
FN ↓
FP ↓
Recall ↑
Precision ↑
FPR ↓
F1 ↑
MCC ↑
Holdout estável ou melhor
Taxonomy estável ou melhor
Duplicidade estável ou menor
~~~

Nem todas as métricas precisam melhorar simultaneamente em toda mudança. Qualquer trade-off deve ser entendido e documentado.

---

# 21. Validação externa recomendada

O benchmark próprio deve ser apenas uma camada de validação.

Para mudanças relevantes nas rules Java:

~~~text
Java Deep Accuracy Benchmark
        ↓
development + holdout

OWASP Benchmark Java
        ↓
validação externa independente

NIST Juliet Java
        ↓
grande variedade de CWEs/dataflows

Aplicações reais controladas
        ↓
comportamento mais próximo de produção
~~~

Não some os denominadores dessas suítes em um único percentual. Cada benchmark possui população e metodologia próprias.

---

# 22. Segurança

Este repositório contém código **deliberadamente vulnerável**.

Ele existe para:

- análise estática;
- benchmark;
- engenharia de rules;
- testes controlados.

Não:

- implante `scan-target/` como serviço exposto;
- copie fixtures vulneráveis para produção;
- execute os casos em infraestrutura aberta;
- insira segredos reais.

Leia também:

[SECURITY.md](SECURITY.md)

---

# 23. Checklist antes e depois do teste

## Antes

- [ ] estou usando o commit correto do benchmark;
- [ ] vou scanear somente `scan-target/`;
- [ ] não incluí ground truth ou documentação;
- [ ] sei qual commit/versão das rules estou testando;
- [ ] vou guardar o JSON bruto;
- [ ] não alterei line tolerance entre before/after;
- [ ] vou avaliar development e holdout;
- [ ] não existem credenciais reais no payload.

## Depois

- [ ] rodei o evaluator;
- [ ] verifiquei TP/TN/FP/FN;
- [ ] verifiquei Recall e FPR;
- [ ] analisei resultados por CWE;
- [ ] analisei resultados por dificuldade;
- [ ] analisei holdout;
- [ ] revisei extraneous/unmatched findings;
- [ ] verifiquei duplicidade;
- [ ] se houve tuning, comparei before × after;
- [ ] documentei regressões e trade-offs.

---

# Resumo

Se você lembrar apenas de quatro coisas:

1. **Scaneie somente `scan-target/`.**
2. **Use o ground truth somente depois do scan.**
3. **Não avalie uma rule apenas pela quantidade de findings.**
4. **Sempre compare FN, FP e holdout antes e depois de uma alteração.**

O objetivo do projeto não é fazer o scanner obter a maior nota possível.

O objetivo é tornar a evolução das rules Java **mensurável, reproduzível, auditável e tecnicamente defensável**.
