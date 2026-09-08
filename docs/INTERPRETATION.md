# Como interpretar resultados

## Não use apenas Accuracy

Como o corpus é balanceado, accuracy é útil, mas ainda deve ser lida junto de:

- Recall: vulnerabilidades encontradas;
- FPR: ruído nos casos seguros;
- Precision: proporção de detecções úteis;
- F1: equilíbrio precision/recall;
- MCC: qualidade global da classificação;
- holdout: generalização;
- taxonomy: qualidade da CWE;
- duplicate rate: custo operacional.

## Exemplo

Um scanner que aumenta recall de 70% para 95% mas leva FPR de 10% para 60% provavelmente ficou mais ruidoso, não necessariamente melhor.

Uma rule que reduz um FP conhecido e mantém todos os TPs é um refinamento mais defensável.

## Comparação entre scanners

Use o mesmo:
- commit do corpus;
- line tolerance;
- regra de dedupe;
- ground truth;
- cohort.

Não compare número bruto de findings como acurácia.
