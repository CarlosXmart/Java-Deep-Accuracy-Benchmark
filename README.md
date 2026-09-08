# Java Deep Accuracy Benchmark

Benchmark controlado e reproduzível para medir **qualidade e acurácia de SAST em Java**, criado para apoiar o refinamento das rules do XGuardian sem confundir aumento de detecção com aumento de ruído.

> [!IMPORTANT]
> ## Caminho que deve ser scaneado
>
> **Envie ao XGuardian somente:**
>
> ```text
> scan-target/
> ```
>
> Não inclua `ground-truth/`, `docs/`, `tools/`, `corpus/`, `benchmark_meta/`, `build-harness/`, `.github/` ou este README no payload do SAST. Essas áreas contêm a verdade esperada, nomes de CWE, metodologia e ferramentas de avaliação e contaminariam o experimento.

## Escopo v1

| Dimensão | Valor |
|---|---:|
| Casos Java pontuados | **600** |
| Vulneráveis intencionais | **300** |
| Seguros / hard-negatives | **300** |
| CWEs | **30** |
| Casos por CWE | **20** |
| Positivos por CWE | **10** |
| Negativos por CWE | **10** |
| Níveis de dificuldade | **5** |
| Development set | **450** |
| Holdout | **150** |
| Java alvo | **17** |

Cada arquivo pontuado tem nome neutro `CaseNNNNNN.java`. Nenhum arquivo dentro de `scan-target/` deve informar ao scanner se é positivo, negativo ou qual CWE está sendo testado.

## Para que este benchmark serve

- medir TP, TN, FP e FN de forma determinística;
- comparar uma rule Java **antes e depois** de um refinamento;
- detectar regressões em CWEs que não estavam sendo modificadas;
- medir precision, recall, FPR, specificity, F1, accuracy, balanced accuracy, MCC e score no estilo OWASP;
- separar **detecção** de **classificação CWE**;
- medir duplicidade, findings extraneous e findings sem correspondência;
- observar desempenho por CWE, dificuldade, framework, dataflow e cohort;
- manter um holdout para reduzir overfitting.

Ele **não** é uma afirmação de “acurácia absoluta em produção”. Um corpus controlado não reproduz toda a distribuição de frameworks, arquitetura, código legado, dependências e dataflows de aplicações reais.

## Base metodológica externa

O projeto é original; os casos não são cópias dos benchmarks externos. A metodologia foi informada por fontes públicas e reconhecidas:

- **OWASP Benchmark for Java** — v1.2 documenta 2.740 casos, 11 áreas de vulnerabilidade e um arquivo `expectedresults-1.2.csv` com o resultado esperado por caso. https://owasp.org/www-project-benchmark/
- **NIST SARD / Juliet Java 1.3** — 28.881 casos Java organizados em 112 CWEs. https://samate.nist.gov/SARD/test-suites/111
- **MITRE CWE** — fonte semântica primária para definição e enquadramento das fraquezas. https://cwe.mitre.org/
- **MITRE 2025 CWE Top 25** — usado como um dos sinais de relevância para parte do escopo. https://cwe.mitre.org/top25/archive/2025/2025_cwe_top25.html
- **GitHub CodeQL Java/Kotlin** — referência secundária para fontes, sinks, recomendações e comportamento de queries. https://codeql.github.com/codeql-query-help/java/
- **SonarSource Java Rules** — referência secundária de padrões de análise estática. https://rules.sonarsource.com/java/

A hierarquia de evidência está documentada em [docs/REFERENCES.md](docs/REFERENCES.md).

## Estrutura

```text
.
├── scan-target/             # ÚNICO diretório que deve ser escaneado
│   └── io/xguardian/javabench/
│       ├── cases/
│       │   ├── level1/
│       │   ├── level2/
│       │   ├── level3/
│       │   ├── level4/
│       │   └── level5/
│       └── support/
├── ground-truth/            # verdade esperada; NÃO scanear
├── corpus/                  # fonte determinística do corpus; NÃO scanear
├── benchmark_meta/          # catálogo e referências; NÃO scanear
├── tools/                   # evaluator/validators; NÃO scanear
├── tests/                   # testes das ferramentas; NÃO scanear
├── build-harness/           # compile-only; NÃO scanear
├── docs/                    # documentação; NÃO scanear
├── results/                 # resultados locais; NÃO scanear
└── .github/workflows/       # CI de integridade
```

## Fluxo recomendado

### 1. Validar o benchmark

```bash
python -m unittest discover -s tests -p "test_*.py" -v
python tools/validate_ground_truth.py
python tools/validate_cases.py
python corpus/generate_cases.py --check
mvn -q -f build-harness/pom.xml -DskipTests compile
```

A compilação **não executa** os caminhos vulneráveis. Ela existe para garantir que os fixtures são Java válido.

### 2. Rodar o XGuardian

Configure a aplicação Java dedicada ao benchmark e envie **somente**:

```text
scan-target/
```

Não ajuste ground truth depois de ver o resultado do scanner para “melhorar a nota”. Qualquer correção de ground truth precisa de justificativa independente e revisão.

### 3. Exportar o resultado JSON do XGuardian

Salve o JSON sem modificá-lo, por exemplo:

```text
results/raw/xguardian-run-001.json
```

### 4. Calcular a pontuação

```bash
python tools/evaluate_xguardian.py \
  results/raw/xguardian-run-001.json \
  --ground-truth ground-truth/ground_truth.json \
  --out results/run-001
```

Saídas:

```text
results/run-001/
├── score.json
├── case_results.csv
├── findings_normalized.json
├── unmatched_findings.json
├── extraneous_findings.json
└── summary.md
```

### 5. Depois de alterar uma rule, rodar novamente

```bash
python tools/compare_runs.py \
  results/run-before/score.json \
  results/run-after/score.json \
  --out results/comparison
```

A análise correta pergunta simultaneamente:

1. quantos FN foram corrigidos;
2. quantos FP foram corrigidos;
3. quantos **novos** FN apareceram;
4. quantos **novos** FP apareceram;
5. como F1, FPR, MCC e taxonomy accuracy mudaram;
6. se a melhoria aparece também no holdout.

## Como TP, TN, FP e FN são definidos

| Ground truth | Finding na região pontuada | Resultado |
|---|---|---|
| vulnerável | sim | **TP** |
| vulnerável | não | **FN** |
| seguro | sim | **FP** |
| seguro | não | **TN** |

A presença de um finding em caso vulnerável conta como detecção. A correção do CWE é avaliada **separadamente** por `taxonomy_exact` e `taxonomy_accepted`.

## Dificuldade

| Level | Objetivo |
|---|---|
| **1** | sink/configuração direta |
| **2** | alias/local indirection |
| **3** | helper/interprocedural |
| **4** | contexto de framework/configuração mais realista |
| **5** | função, supplier, wrapper ou indirection adicional |

Nem toda CWE é naturalmente uma taint-flow vulnerability. Em crypto/TLS/cookie configuration, por exemplo, a progressão mede **indirection/configuration reasoning**, não “distância da entrada do usuário”.

## Holdout

O v1 reserva **150 casos (25%)** como `holdout`, balanceados em **75 vulneráveis + 75 seguros**, com 30 casos em cada nível. Veja [docs/HOLDOUT_POLICY.md](docs/HOLDOUT_POLICY.md).

Durante tuning de rules, priorize o development set. Use o holdout como verificação de generalização. Não ajuste uma rule especificamente para IDs do holdout.

## Documentação

- [Metodologia](docs/METHODOLOGY.md)
- [Scoring e fórmulas](docs/SCORING.md)
- [Uso com XGuardian](docs/XGUARDIAN_USAGE.md)
- [Guia de tuning de rules](docs/RULE_TUNING_GUIDE.md)
- [Política de ground truth](docs/GROUND_TRUTH_POLICY.md)
- [Política de holdout](docs/HOLDOUT_POLICY.md)
- [Guia para criação de casos](docs/CASE_AUTHORING_GUIDE.md)
- [Quality gates](docs/QUALITY_GATES.md)
- [Validação externa](docs/EXTERNAL_VALIDATION.md)
- [Limitações](docs/KNOWN_LIMITATIONS.md)
- [Reprodutibilidade](docs/REPRODUCIBILITY.md)
- [Catálogo das 30 CWEs](docs/CORPUS_CATALOG.md)
- [Referências](docs/REFERENCES.md)
- [Baseline](docs/BASELINE.md)
- [Documentação individual por CWE](docs/cwe/)

## Baseline XGuardian v1

**[LACUNA]** Ainda não existe uma pontuação XGuardian válida para este corpus Java de 600 casos. O baseline só deve ser preenchido após um scan real de `scan-target/` no XGuardian e avaliação do JSON exportado.

Não reutilize os 95% obtidos pelo benchmark Java anterior de 20 casos como se fossem resultado deste corpus. São populações diferentes.

## Regra de ouro

> Uma rule não ficou melhor apenas porque encontrou mais vulnerabilidades.

Uma alteração é boa quando aumenta cobertura **sem deteriorar de forma desproporcional falsos positivos, outras CWEs, holdout, taxonomia ou duplicidade**.

---

Este repositório contém código deliberadamente inseguro para **análise estática controlada**. Não use os fixtures como código de produção e não execute caminhos vulneráveis em sistemas expostos.
