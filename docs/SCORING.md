# Scoring

## Matriz de confusão

- **TP:** expected_vulnerable=true e pelo menos um finding na região.
- **FN:** expected_vulnerable=true e nenhum finding na região.
- **TN:** expected_vulnerable=false e nenhum finding na região.
- **FP:** expected_vulnerable=false e pelo menos um finding na região.

## Fórmulas

```text
Precision   = TP / (TP + FP)
Recall/TPR  = TP / (TP + FN)
FPR         = FP / (FP + TN)
Specificity = TN / (TN + FP)
F1          = 2 * Precision * Recall / (Precision + Recall)
Accuracy    = (TP + TN) / Total
Balanced Accuracy = (Recall + Specificity) / 2
```

MCC também é calculado para reduzir a dependência de uma única métrica.

## OWASP-style score

O evaluator também expõe:

```text
100 * (TPR - FPR)
```

Essa métrica é útil para visualizar simultaneamente ganho de cobertura e custo de falsos positivos.

## Taxonomia

- **taxonomy_exact_accuracy:** preferred_cwe correto entre TPs.
- **taxonomy_accepted_accuracy:** qualquer CWE listado em accepted_cwes entre TPs.

## Duplicidade

`duplicate_finding_rate` mede findings adicionais que apontam para a mesma combinação normalizada de arquivo, linha e CWE.

## Gates sugeridos

Para considerar uma alteração positiva:

1. nenhum FN novo em calibration;
2. nenhum FN novo em holdout;
3. FPR não pode aumentar materialmente;
4. nenhum CWE anteriormente 100% coberto deve regredir;
5. melhoria deve ser analisada por dificuldade, não apenas no agregado.
