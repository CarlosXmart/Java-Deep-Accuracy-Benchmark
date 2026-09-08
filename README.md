# Java Deep Accuracy Benchmark

A large, controlled and reproducible benchmark for evaluating **Java SAST accuracy** and regression behavior.

The project is designed to answer a practical engineering question:

> **Did a static-analysis rule actually improve, or did it only detect more code while increasing noise?**

The benchmark provides a known ground truth, paired vulnerable/safe cases, progressive difficulty, a development cohort, a holdout cohort, automated scoring and before/after comparison.

## Quick start

### 1. Scan only this directory

```text
scan-target/
```

> **Do not scan the whole repository.**
>
> `ground-truth/`, `docs/`, `corpus/`, `tools/` and other repository files contain expected outcomes, CWE metadata and evaluation logic. Including them in the scan payload can contaminate the experiment.

### 2. Export the scanner result as JSON

Keep the raw export unchanged for reproducibility.

### 3. Score it

```bash
python tools/evaluate_results.py \
  results/raw/run-001.json \
  --ground-truth ground-truth/ground_truth.json \
  --out results/run-001
```

### 4. Compare a rule change

```bash
python tools/compare_runs.py \
  results/before/score.json \
  results/after/score.json \
  --out results/comparison
```

## Scope

| Dimension | Value |
|---|---:|
| Scored Java cases | **600** |
| Intentionally vulnerable | **300** |
| Safe / hard-negative | **300** |
| CWE categories | **30** |
| Cases per CWE | **20** |
| Vulnerable cases per CWE | **10** |
| Safe cases per CWE | **10** |
| Difficulty levels | **5** |
| Cases per level | **120** |
| Development cohort | **450** |
| Holdout cohort | **150** |
| Java target | **17** |

Every scored file has a neutral name:

```text
Case000001.java
Case000002.java
...
Case000600.java
```

Nothing inside the scan payload identifies a case as vulnerable/safe, TP/TN/FP/FN, or reveals the expected CWE.

## Scan payload

The official scan target is:

```text
scan-target/
└── org/
    └── javadeep/
        └── benchmark/
            ├── cases/
            │   ├── level1/
            │   ├── level2/
            │   ├── level3/
            │   ├── level4/
            │   └── level5/
            └── support/
```

The `support/` package is part of the payload because some hard-negatives intentionally rely on shared validation, escaping and allowlist helpers.

Do **not** include:

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

## TP, TN, FP and FN

| Ground truth | Finding in scored region | Result |
|---|---|---|
| Vulnerable | Yes | **TP** |
| Vulnerable | No | **FN** |
| Safe | Yes | **FP** |
| Safe | No | **TN** |

- **TP:** a known vulnerable case was detected.
- **FN:** a known vulnerable case was missed.
- **FP:** a known safe/hard-negative case was reported.
- **TN:** a known safe/hard-negative case was correctly left clean.

Detection and CWE taxonomy are scored separately.

## Metrics

The evaluator calculates:

- TP / TN / FP / FN
- Precision
- Recall / TPR
- False Positive Rate
- Specificity
- F1
- Accuracy
- Balanced Accuracy
- Matthews Correlation Coefficient
- OWASP-style score: `100 × (TPR - FPR)`
- exact and accepted CWE taxonomy accuracy
- raw and normalized finding counts
- duplicate finding rate
- unmatched findings
- extraneous findings

Breakdowns are produced by CWE, difficulty, framework, cohort and dataflow.

## Difficulty model

| Level | Primary challenge |
|---|---|
| **1** | direct source/sink or configuration |
| **2** | local alias / intermediate value |
| **3** | helper / interprocedural reasoning |
| **4** | framework or contextual configuration |
| **5** | Function, Supplier, wrapper or extra indirection |

Not every CWE is a classic taint-flow weakness. For TLS, cryptography, cookies and other configuration-oriented cases, difficulty represents configuration/indirection reasoning.

## Development and holdout

The corpus is split into:

- **450 development cases**
- **150 holdout cases**
  - 75 vulnerable
  - 75 safe
  - 30 per difficulty level

Use development cases while tuning rules. Use holdout as a generalization check.

The holdout is a **process holdout**, not a cryptographically hidden set. For a genuinely blind evaluation, use a separately controlled holdout or an independent benchmark not inspected during tuning.

## Covered CWEs

The v1 corpus covers:

`CWE-22`, `CWE-78`, `CWE-79`, `CWE-89`, `CWE-90`, `CWE-94`, `CWE-113`, `CWE-209`, `CWE-295`, `CWE-319`, `CWE-321`, `CWE-327`, `CWE-328`, `CWE-330`, `CWE-347`, `CWE-352`, `CWE-400`, `CWE-434`, `CWE-470`, `CWE-502`, `CWE-532`, `CWE-601`, `CWE-611`, `CWE-614`, `CWE-643`, `CWE-798`, `CWE-862`, `CWE-918`, `CWE-1004` and `CWE-1333`.

See [docs/CORPUS_CATALOG.md](docs/CORPUS_CATALOG.md) and [docs/cwe/](docs/cwe/) for the rationale and official MITRE reference for every category.

## Ground truth

The canonical expected outcomes are stored in:

```text
ground-truth/ground_truth.json
```

Each case records:

- neutral ID and path
- expected vulnerable/safe state
- preferred and accepted CWE
- category
- difficulty
- framework/context
- source and sink/configuration
- dataflow type
- scored line region
- rationale
- official MITRE CWE reference
- development/holdout cohort

Ground truth must not be changed merely because a scanner disagrees. Semantic changes require independent technical justification.

## Validation

Run the complete integrity suite:

```bash
python -m unittest discover -s tests -p "test_*.py" -v
python tools/validate_ground_truth.py
python tools/validate_cases.py
python tools/validate_public_release.py
python corpus/generate_cases.py --check
mvn -q -f build-harness/pom.xml -DskipTests compile
```

The Maven step compiles the Java fixtures but does not execute vulnerable code paths.

## Recommended rule-tuning workflow

1. Freeze the benchmark commit.
2. Run the scanner before the rule change.
3. Save the raw result and evaluator output.
4. Diagnose the specific FP/FN pattern.
5. Implement the smallest semantically justified change.
6. Run the same corpus with the same configuration.
7. Compare fixed/new FP and FN.
8. Check holdout behavior.
9. Check taxonomy and duplicate rate.
10. Record regressions and trade-offs.

A rule is not better merely because it creates more findings.

## External methodology references

The 600 fixtures in this repository are original. The methodology is informed by public, recognized sources:

- **OWASP Benchmark for Java** — https://owasp.org/www-project-benchmark/
- **NIST SARD / Juliet Java 1.3** — https://samate.nist.gov/SARD/test-suites/111
- **MITRE CWE** — https://cwe.mitre.org/
- **MITRE CWE Top 25** — https://cwe.mitre.org/top25/
- **GitHub CodeQL Java/Kotlin query help** — https://codeql.github.com/codeql-query-help/java/
- **SonarSource Java rules** — https://rules.sonarsource.com/java/

A custom benchmark should not be the only evidence of scanner quality. For significant rule releases, triangulate with independent suites and controlled real-world applications.

## Limitations

A synthetic corpus is smaller and cleaner than real production systems. It cannot reproduce every framework, dependency graph, architecture, legacy pattern or long-range dataflow.

The 50/50 vulnerable/safe distribution is intentional for calibration and does not represent real-world vulnerability prevalence.

Report results as:

> **accuracy on this benchmark version and scanner configuration**

not as absolute accuracy across all Java software.

## Documentation

- [Methodology](docs/METHODOLOGY.md)
- [Scoring](docs/SCORING.md)
- [Scanner usage](docs/SCANNER_USAGE.md)
- [Rule tuning guide](docs/RULE_TUNING_GUIDE.md)
- [Ground-truth policy](docs/GROUND_TRUTH_POLICY.md)
- [Holdout policy](docs/HOLDOUT_POLICY.md)
- [Case authoring guide](docs/CASE_AUTHORING_GUIDE.md)
- [Quality gates](docs/QUALITY_GATES.md)
- [External validation](docs/EXTERNAL_VALIDATION.md)
- [Known limitations](docs/KNOWN_LIMITATIONS.md)
- [Reproducibility](docs/REPRODUCIBILITY.md)
- [Change control](docs/CHANGE_CONTROL.md)
- [Interpretation](docs/INTERPRETATION.md)
- [Corpus catalog](docs/CORPUS_CATALOG.md)
- [References](docs/REFERENCES.md)
- [Baseline guidance](docs/BASELINE.md)
- [Per-CWE documentation](docs/cwe/)

## Security

This repository intentionally contains vulnerable code for static-analysis testing.

- Do not deploy `scan-target/` as an exposed application.
- Do not copy vulnerable fixtures into production.
- Do not add real credentials, private keys, access tokens, private network addresses or internal endpoints.
- The CI includes a public-release hygiene validator.

See [SECURITY.md](SECURITY.md).

## License

Apache License 2.0. See [LICENSE](LICENSE).

## Contact

Carlos Gabriel — carlos.gabriel@xmartsolutions.com.br
