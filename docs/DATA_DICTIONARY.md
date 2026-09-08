# Dicionário do ground truth

Cada objeto em `ground-truth/ground_truth.json` contém:

| Campo | Significado |
|---|---|
| id | identificador estável do caso |
| path | caminho exato dentro do diretório de scan |
| expected_vulnerable | verdade esperada |
| preferred_cwe | CWE principal |
| accepted_cwes | CWEs aceitos para taxonomia |
| category | nome curto da categoria |
| difficulty | nível 1–5 |
| set | calibration ou holdout |
| variant | variante A/B |
| start_line | primeira linha pontuada |
| end_line | última linha pontuada |
| official_reference | MITRE CWE |
| rationale | justificativa resumida |
| safe_control | controle esperado no caso negativo |

Os nomes dos arquivos escaneados são neutros. A expectativa fica apenas fora do `scan-target/`.
