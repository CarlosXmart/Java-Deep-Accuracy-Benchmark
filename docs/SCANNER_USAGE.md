# Running the benchmark with a SAST scanner

## Official scan path

Scan **only**:

```text
scan-target/
```

Do not scan the repository root. Ground truth, documentation and evaluator logic must remain outside the scan payload.

## Recommended metadata for every run

Record:

- benchmark commit SHA;
- scanner name/version;
- rule pack/version or commit when available;
- run identifier;
- date/time;
- relevant scanner configuration;
- raw JSON result;
- evaluator commit/version.

Do not commit credentials or private environment details.

## Evaluate

```bash
python tools/evaluate_results.py \
  results/raw/run.json \
  --ground-truth ground-truth/ground_truth.json \
  --out results/run
```

The default line tolerance is 2. Keep it constant between before/after comparisons unless the matching policy itself is part of the experiment.

## Compare

```bash
python tools/compare_runs.py \
  results/before/score.json \
  results/after/score.json \
  --out results/comparison
```

## JSON interoperability

The evaluator normalizes common aliases for file path, line and CWE fields. If a scanner exports a different schema, add a small adapter that produces equivalent finding objects rather than changing ground truth.
