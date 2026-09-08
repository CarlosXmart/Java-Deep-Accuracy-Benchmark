# Metodologia

## 1. Objetivo científico/engenharia

O Java Deep Accuracy Benchmark é uma suíte controlada para comparar versões de um scanner SAST e, principalmente, alterações de rules. O design privilegia **reprodutibilidade, ground truth explícito e simetria entre casos positivos e hard-negatives**.

A pergunta central é:

> Para uma condição Java cuja verdade é conhecida, o scanner detecta o caso vulnerável e evita alertar o caso seguro equivalente?

O benchmark não tenta estimar prevalência de vulnerabilidades em produção. A distribuição 50/50 é intencional para calibração.

## 2. População

- 600 casos;
- 30 CWEs;
- 20 casos por CWE;
- 10 vulneráveis e 10 seguros por CWE;
- 5 níveis;
- 120 casos por nível;
- 450 development;
- 150 holdout.

A unidade primária de scoring é **o caso**, não o finding bruto.

## 3. Pareamento positivo/negativo

Sempre que a semântica permite, os casos são construídos em pares que mantêm contexto semelhante e alteram o controle de segurança relevante.

Exemplo conceitual de CWE-78:

```java
// vulnerável: shell interpreta uma string influenciada externamente
new ProcessBuilder("sh", "-c", "echo " + input).start();

// hard-negative: programa fixo + argumentos separados, sem shell
new ProcessBuilder(List.of("printf", "%s", input)).start();
```

O segundo caso existe justamente para medir scanner excessivamente sintático.

## 4. Ground truth

A verdade esperada fica fora do scan em:

```text
ground-truth/ground_truth.json
```

Cada registro contém:

- ID neutro;
- caminho;
- `expected_vulnerable`;
- CWE preferida;
- CWEs aceitas;
- categoria;
- dificuldade;
- framework/contexto;
- source;
- sink;
- tipo de dataflow/configuração;
- região pontuada;
- rationale;
- referência MITRE oficial;
- cohort.

A fonte semântica primária para cada fraqueza é o MITRE CWE. Referências de CodeQL/SonarSource são auxiliares e não podem redefinir o ground truth.

## 5. Região pontuada

Cada caso possui `target_start_line` e `target_end_line`.

O evaluator usa tolerância de linha configurável (default 2) porque scanners diferentes podem apontar a source, a construção intermediária ou o sink adjacente.

Findings no mesmo arquivo mas fora da região são registrados como `extraneous_findings` e não transformam silenciosamente o caso em TP/FP.

## 6. Detecção e taxonomia são separadas

Um SAST pode encontrar um problema real e classificá-lo em CWE relacionada, porém diferente.

Por isso:

- **Detection:** o problema foi encontrado na região?
- **Taxonomy exact:** a CWE preferida foi retornada?
- **Taxonomy accepted:** alguma CWE explicitamente aceita no ground truth foi retornada?

Isso evita transformar erro taxonômico automaticamente em FN.

## 7. Deduplicação

Antes do scoring, findings são normalizados por:

```text
path + line + CWE
```

A linha é convertida para inteiro. Isso evita o problema clássico em que `"5"` e `5` são tratados como findings diferentes.

Duplicidades continuam sendo medidas por `duplicate_rate`.

## 8. Dificuldade progressiva

### Level 1 — direto
Fonte/sink ou configuração de risco é explícita.

### Level 2 — alias/local
Introduz variável intermediária ou configuração local.

### Level 3 — interprocedural
Introduz helper/factory/método auxiliar.

### Level 4 — framework/configuração
Usa request/body/principal de Jakarta Servlet ou configuração/factory mais próxima de código real, conforme a CWE.

### Level 5 — indirection
Usa `Function`, `Supplier`, `Predicate`, wrapper ou indirection equivalente.

**Importante:** CWEs de configuração (TLS, algoritmos, flags de cookie etc.) não possuem um source-to-sink taint flow clássico. Nelas, dificuldade significa rastrear configuração/resultado através de indirection.

## 9. Holdout

25% dos casos são marcados `holdout`.

A divisão é estratificada:
- 150 total;
- 75 vulneráveis;
- 75 seguros;
- 30 por nível;
- um holdout por CWE por nível.

O holdout está versionado para reprodutibilidade. Ele não é secreto criptograficamente; é um **process holdout**. Quem ajusta rules deve evitar consultar IDs/implementações do holdout durante tuning.

## 10. Referências externas

### OWASP Benchmark
A OWASP documenta na versão Java 1.2:
- 2.740 casos;
- 11 áreas;
- cada caso como verdadeiro problema ou falso positivo de uma CWE;
- expected results distribuídos com o benchmark.

Fonte: https://owasp.org/www-project-benchmark/

### NIST Juliet Java
O NIST SARD informa para Juliet Java 1.3:
- 28.881 casos;
- 112 CWEs;
- Java;
- 73,2 MB;
- submissão em 01/10/2017.

Fonte: https://samate.nist.gov/SARD/test-suites/111

### MITRE 2025 CWE Top 25
A metodologia de 2025 analisou 39.080 registros CVE publicados entre 01/06/2024 e 01/06/2025 para compor o ranking.

Fonte: https://cwe.mitre.org/top25/archive/2025/2025_methodology.html

Esses números são contexto externo. **Nenhum deles é usado como denominador do score target SAST scanner deste projeto.**

## 11. Ameaças à validade

Mesmo com 600 casos, permanecem ameaças:

- casos sintéticos são menores que aplicações corporativas;
- distribuição 50/50 não representa prevalência real;
- algumas frameworks não estão incluídas;
- bibliotecas/dependências podem alterar dataflow;
- um scanner pode overfitar se os casos forem usados diretamente para escrever rules;
- line tolerance pode influenciar matching;
- a definição de “safe” é específica à condição testada, não uma certificação de segurança completa do arquivo.

Por isso, o resultado deve ser triangulado com holdout, OWASP Benchmark, NIST Juliet e aplicações reais controladas.
