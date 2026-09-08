# Uso com XGuardian

## Regra crítica

### Scaneie somente

```text
scan-target/
```

O benchmark foi desenhado para que `scan-target/` seja autocontido como payload SAST.

### Nunca envie no mesmo scan

```text
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
```

Esses diretórios revelam CWEs e resultados esperados.

## Preparação

1. Use uma aplicação XGuardian dedicada a benchmark.
2. Identifique o commit/branch exato do corpus.
3. Não adicione outras fontes ao ZIP.
4. Não use exclusões que removam `CaseNNNNNN.java`.
5. Mantenha tradução/PDF desativados se não forem necessários à medição.
6. Preserve o JSON bruto exportado.

## Scan

Payload esperado:

```text
scan-target/
└── io/xguardian/javabench/
    ├── cases/
    │   ├── level1/
    │   ├── level2/
    │   ├── level3/
    │   ├── level4/
    │   └── level5/
    └── support/
```

O `support/` faz parte do payload porque alguns hard-negatives dependem de controles centralizados como escaping, allowlist e validação de redirect/host.

## Avaliação

```bash
python tools/evaluate_xguardian.py resultado_xguardian.json \
  --ground-truth ground-truth/ground_truth.json \
  --out results/run-001
```

Default:

```text
line tolerance = 2
```

Não altere tolerance entre before/after sem registrar isso.

## Resultado mínimo a guardar

Para cada execução, registre:

- data;
- commit do benchmark;
- commit/versão do engine/rules;
- scan ID;
- app ID;
- configuração relevante do SAST;
- JSON bruto;
- evaluator version/commit;
- `score.json`;
- `case_results.csv`.

Não armazene tokens ou credenciais no repositório.

## Antes/depois

Rode o **mesmo corpus** e as mesmas configurações:

```bash
python tools/compare_runs.py \
  results/before/score.json \
  results/after/score.json \
  --out results/comparison
```

Mudar corpus e rules ao mesmo tempo destrói a comparabilidade.

## Resultado inicial

**[LACUNA]** O corpus v1 de 600 casos ainda precisa ser scaneado no XGuardian. Até isso ocorrer, qualquer score atribuído a ele é inválido.
