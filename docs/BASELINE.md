# Baseline guidance

This repository intentionally does **not** publish a vendor-specific benchmark score.

A baseline is only meaningful when it records:

- exact benchmark commit;
- scanner and rules version;
- scan configuration;
- raw scanner result;
- evaluator version;
- overall metrics;
- development/holdout metrics;
- per-CWE and per-difficulty breakdowns.

Generate a baseline with:

```bash
python tools/evaluate_results.py \
  results/raw/baseline.json \
  --ground-truth ground-truth/ground_truth.json \
  --out results/baseline
```

Do not compare results generated from different corpus versions as though they were the same experiment.
