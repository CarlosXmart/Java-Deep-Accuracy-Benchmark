# Ground truth

Este diretório **nunca deve ser enviado ao SAST**.

O score oficial usa `ground_truth.json`, que contém 600 casos com expectativa conhecida, região pontuada e referência MITRE.

- 300 vulneráveis
- 300 seguros/hard-negatives
- 420 calibration
- 180 holdout
- 30 CWEs
- 5 níveis

`expected_results.csv` existe para inspeção humana e integração com outras ferramentas.

Qualquer alteração de expected result deve ser revisada separadamente da alteração de rules do scanner.
