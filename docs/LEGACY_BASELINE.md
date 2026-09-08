# Baseline Java anterior — referência histórica

O benchmark Java anterior tinha apenas 20 casos.

Resultado observado após o refinamento que antecedeu este projeto:

| Métrica | Resultado |
|---|---:|
| TP | 10 |
| FN | 0 |
| FP | 1 |
| TN | 9 |
| Precision | 90,9% |
| Recall | 100% |
| F1 | 95,2% |
| Accuracy | 95% |

O FP remanescente era o hard-negative de command execution com `ProcessBuilder` usando executável fixo e argumentos separados.

**Não compare diretamente 95% desse corpus de 20 casos com o score deste benchmark de 600 casos.** O novo corpus é deliberadamente mais amplo e mais difícil.
