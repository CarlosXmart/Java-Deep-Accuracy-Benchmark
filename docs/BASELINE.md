# Baseline

## Java Deep Accuracy Benchmark v1

**[LACUNA] Nenhum scan XGuardian deste corpus de 600 casos foi avaliado ainda.**

Preencher somente depois de:

1. validar CI;
2. scanear **somente `scan-target/`**;
3. preservar JSON bruto;
4. executar `tools/evaluate_xguardian.py`;
5. registrar commit do corpus e versão/commit das rules.

## Referência histórica — benchmark Java anterior

O benchmark poliglota anterior tinha somente 20 casos Java. Após refinamentos, a medição observada foi:

| Métrica | Resultado histórico |
|---|---:|
| TP | 10 |
| TN | 9 |
| FP | 1 |
| FN | 0 |
| Precision | 90,9% |
| Recall | 100% |
| Accuracy | 95% |
| FPR | 10% |

Esse valor é **contexto histórico** e não é baseline do novo projeto.

O novo corpus é 30x maior no número de casos Java (600 vs. 20), cobre 30 CWEs e possui dificuldade/holdout próprios. Comparar percentuais diretamente sem considerar a população seria metodologicamente incorreto.
