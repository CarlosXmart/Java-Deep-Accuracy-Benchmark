# Scoring

## Matriz de confusão por caso

| Esperado | Detectado | Classe |
|---|---|---|
| Vulnerável | Sim | TP |
| Vulnerável | Não | FN |
| Seguro | Sim | FP |
| Seguro | Não | TN |

## Fórmulas

```text
Precision   = TP / (TP + FP)
Recall/TPR  = TP / (TP + FN)
FPR         = FP / (FP + TN)
Specificity = TN / (TN + FP)
F1          = 2 * Precision * Recall / (Precision + Recall)
Accuracy    = (TP + TN) / (TP + TN + FP + FN)
Balanced Accuracy = (TPR + Specificity) / 2
```

### Matthews Correlation Coefficient

```text
MCC = (TP*TN - FP*FN) /
      sqrt((TP+FP)(TP+FN)(TN+FP)(TN+FN))
```

MCC é importante porque usa os quatro quadrantes da matriz.

### Score no estilo OWASP Benchmark

```text
100 * (TPR - FPR)
```

Este projeto chama a métrica explicitamente de **OWASP-style score** para não sugerir que o evaluator é o evaluator oficial da OWASP.

## Taxonomia

```text
Taxonomy Exact Accuracy =
TPs com preferred_cwe observada / TPs avaliados

Taxonomy Accepted Accuracy =
TPs com alguma accepted_cwes observada / TPs avaliados
```

Taxonomia não altera TP/FN. É um eixo separado.

## Findings brutos e duplicidade

O evaluator registra:

- `raw_findings`;
- `normalized_findings`;
- `duplicate_findings`;
- `duplicate_rate`;
- `target_region_findings`;
- `findings_per_detected_vulnerable_case`;
- `unmatched_findings`;
- `extraneous_findings`.

Uma ferramenta pode ter bom recall e ainda gerar volume operacional ruim. Por isso, duplicate rate e FPR não devem ser ignorados.

## Breakdowns

`score.json` contém resultados por:

- CWE;
- difficulty;
- framework;
- cohort;
- dataflow.

## Interpretação de regressão

Uma alteração deve ser considerada suspeita quando:

- aumenta TP, mas aumenta FP de forma material;
- corrige uma CWE e quebra outra;
- melhora development e piora holdout;
- melhora detection e degrada fortemente taxonomy;
- aumenta muito duplicidade;
- depende de widening de line tolerance para parecer melhor.

Não há threshold universal embutido no v1. O projeto fornece os dados; gates de produto devem ser definidos e versionados conforme baseline real do target SAST scanner.
