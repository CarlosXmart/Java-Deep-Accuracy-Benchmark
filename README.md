# Java Deep Accuracy Benchmark

Benchmark Java especializado para avaliar **qualidade e acurácia de SAST** durante o refinamento de rules do XGuardian.

> **Diretório oficial de scan: `scan-target/`**
>
> Para o score completo, envie **somente `scan-target/`** ao SAST. Não inclua `ground-truth/`, `docs/`, `tools/`, `results/`, `.github/` ou `build-harness/`.

## Resumo

| Item | Valor |
|---|---:|
| Casos Java pontuados | **600** |
| Vulneráveis | **300** |
| Seguros / hard-negatives | **300** |
| CWEs | **30** |
| Níveis de dificuldade | **5** |
| Calibration set | **420** |
| Holdout set | **180** |
| Casos por CWE | **20** |

O projeto foi desenhado com princípios observados em benchmarks reais de análise estática:

- **OWASP Benchmark for Java**: milhares de casos com expected results, vulneráveis e não vulneráveis, e scorecard por ferramenta.
- **NIST/NSA Juliet Java**: suíte criada para avaliação de ferramentas de análise estática, com grande diversidade de CWEs e variantes de fluxo.
- **MITRE CWE**: fonte de referência para a taxonomia e definição de cada fraqueza.

Não copiamos casos desses projetos. Os casos deste repositório são sintéticos e independentes; as referências são metodológicas e taxonômicas.

## Como usar

### 1. Durante refinamento de rules

Escaneie apenas o conjunto de calibração:

```text
scan-target/io/xguardian/javabench/cases/calibration/
```

Use-o para observar regressões rapidamente enquanto altera rules.

### 2. Antes de considerar a rule pronta

Execute o score oficial sobre:

```text
scan-target/
```

Isso inclui calibration + holdout.

### 3. Avalie o JSON do XGuardian

```bash
python3 tools/evaluate_xguardian.py \
  --results results/xguardian.json \
  --ground-truth ground-truth/ground_truth.json \
  --out results/score.json
```

### 4. Compare antes/depois

```bash
python3 tools/compare_runs.py \
  results/before/score.json \
  results/after/score.json
```

## O que significa TP/TN/FP/FN?

| Resultado | Significado |
|---|---|
| TP | caso vulnerável e finding encontrado na região pontuada |
| FN | caso vulnerável sem finding na região pontuada |
| TN | hard-negative seguro sem finding na região pontuada |
| FP | hard-negative seguro com finding na região pontuada |

**Detecção e taxonomia são separadas.** Um finding na região pode contar como detecção, enquanto o CWE retornado pode ser avaliado como incorreto.

## Estrutura

```text
.
├── scan-target/                 # ÚNICO DIRETÓRIO DO SCORE OFICIAL
│   └── io/xguardian/javabench/
│       ├── cases/
│       │   ├── calibration/
│       │   └── holdout/
├── build-harness/               # Maven; não deve entrar no scan
├── ground-truth/                # verdade conhecida; não deve entrar no scan
├── docs/
│   └── cwe/                     # documentação específica das 30 CWEs
├── tools/                       # evaluator e validadores
├── results/                     # resultados locais; ignorados pelo Git
└── .github/workflows/
```

## Regras para não contaminar o benchmark

1. Não mover ground truth para dentro de `scan-target/`.
2. Não renomear casos com `TP`, `TN`, `vulnerable`, `safe` ou nomes de CWE.
3. Não calibrar rules usando o conteúdo do holdout.
4. Não alterar caso e expected result no mesmo refinamento sem revisão técnica.
5. Registrar baseline antes e depois de cada mudança relevante.
6. Nunca considerar aumento de recall isoladamente uma melhoria se o FPR subir de forma material.

## Documentação

- [Metodologia](docs/METHODOLOGY.md)
- [Scoring](docs/SCORING.md)
- [Uso com XGuardian](docs/XGUARDIAN_USAGE.md)
- [Guia de tuning](docs/RULE_TUNING_GUIDE.md)
- [Política de holdout](docs/HOLDOUT_POLICY.md)
- [Validação externa](docs/EXTERNAL_VALIDATION.md)
- [Limitações](docs/KNOWN_LIMITATIONS.md)
- [Cobertura CWE](docs/CWE_COVERAGE.md)
- [Catálogo CWE](docs/cwe/INDEX.md)

## Referências

- OWASP Benchmark: https://owasp.org/www-project-benchmark/
- NIST SARD — Juliet Java 1.3: https://samate.nist.gov/SARD/test-suites/111
- NIST — publicação Juliet: https://www.nist.gov/publications/juliet-11-cc-and-java-test-suite
- MITRE CWE: https://cwe.mitre.org/

## Importante

Este benchmark mede o comportamento do scanner **neste corpus e configuração**. Ele é uma suíte de regressão/calibração e uma aproximação controlada da qualidade; não representa uma porcentagem absoluta de acurácia em todo código Java real.
