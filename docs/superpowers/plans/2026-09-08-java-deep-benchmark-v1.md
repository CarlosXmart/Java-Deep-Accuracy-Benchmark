# Java Deep Accuracy Benchmark v1 Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Build a reproducible Java-only SAST accuracy benchmark with 600 scored cases, independent ground truth, automated evaluation, regression comparison, anti-leakage validation, and documentation grounded in OWASP Benchmark, NIST Juliet/SARD, MITRE CWE, GitHub CodeQL, and SonarSource references.

**Architecture:** The repository separates the scan payload (`scan-target/`) from all truth/evaluation material. A deterministic corpus generator materializes 600 neutral Java fixtures from reviewed CWE templates, while machine-readable ground truth stores expected outcome, CWE, difficulty, source/sink, dataflow, rationale, references, and cohort. Python tooling validates the corpus, evaluates XGuardian JSON, compares runs, and produces overall/per-CWE/per-difficulty metrics.

**Tech Stack:** Java 17 fixtures, Maven validation harness, Python 3.11+ standard library + pytest for tooling tests, GitHub Actions.

**Spec:** `docs/superpowers/specs/2026-09-08-java-deep-accuracy-benchmark-design.md`

## Global Constraints

- Exactly 600 scored Java cases.
- Exactly 300 intentionally vulnerable and 300 intentionally safe/hard-negative.
- Exactly 30 CWE families; 20 cases per CWE; 10 vulnerable and 10 safe per CWE.
- Five progressive difficulty levels.
- The only path intended for XGuardian SAST scanning is `scan-target/`.
- Ground truth, documentation, tooling, build metadata, results, and workflow files must never be included in the XGuardian scan payload.
- No TP/TN/FP/FN/CWE/SAFE/VULNERABLE benchmark labels may leak into `scan-target/`.
- Detection scoring and taxonomy scoring are independent.
- No real credentials, tokens, API keys, or secrets.
- Validation must not execute vulnerable paths.
- The benchmark is a controlled calibration/regression suite, not an absolute production-accuracy claim.
- Official semantic authority for weakness definitions is MITRE CWE; OWASP Benchmark and NIST Juliet/SARD are methodological/external benchmark references; GitHub CodeQL and SonarSource are secondary implementation-pattern references.

---

## File Structure

```text
README.md
LICENSE
.gitignore
.github/workflows/benchmark-validation.yml
build-harness/pom.xml
benchmark_meta/cwe_catalog.json
benchmark_meta/reference_snapshot.json
benchmark_meta/schema.json
corpus/templates.json
corpus/generate_cases.py
ground-truth/ground_truth.json
ground-truth/expected_results.csv
ground-truth/expected_counts.json
docs/METHODOLOGY.md
docs/SCORING.md
docs/XGUARDIAN_USAGE.md
docs/RULE_TUNING_GUIDE.md
docs/EXTERNAL_VALIDATION.md
docs/BASELINE.md
docs/REFERENCES.md
docs/CORPUS_CATALOG.md
docs/cwe/CWE-*.md
scan-target/io/xguardian/javabench/cases/level1/Case*.java
scan-target/io/xguardian/javabench/cases/level2/Case*.java
scan-target/io/xguardian/javabench/cases/level3/Case*.java
scan-target/io/xguardian/javabench/cases/level4/Case*.java
scan-target/io/xguardian/javabench/cases/level5/Case*.java
scan-target/io/xguardian/javabench/support/*.java
tests/test_evaluator.py
tests/test_ground_truth.py
tests/test_corpus.py
tests/fixtures/xguardian_known_result.json
tools/evaluate_xguardian.py
tools/validate_ground_truth.py
tools/validate_cases.py
tools/compare_runs.py
tools/benchmark_lib.py
results/.gitkeep
```

### Task 1: Metadata, source catalog, schema, and deterministic corpus definition

**Files:**
- Create: `benchmark_meta/cwe_catalog.json`
- Create: `benchmark_meta/reference_snapshot.json`
- Create: `benchmark_meta/schema.json`
- Create: `corpus/templates.json`
- Create: `corpus/generate_cases.py`
- Create: `tests/test_corpus.py`

**Interfaces:**
- Produces: deterministic case records with fields `id`, `path`, `expected_vulnerable`, `preferred_cwe`, `accepted_cwes`, `category`, `difficulty`, `framework`, `source`, `sink`, `dataflow`, `target_start_line`, `target_end_line`, `rationale`, `official_reference`, `cohort`.
- Consumes: reviewed 30-CWE catalog and case templates.

- [ ] Write tests that assert 30 CWEs, 20 cases/CWE, 10 vulnerable/10 safe, 5 levels, neutral filenames, unique IDs/paths, and deterministic generation.
- [ ] Run tests and confirm failure before implementation.
- [ ] Implement catalog/schema/template data and deterministic generator.
- [ ] Run tests and confirm all corpus-definition tests pass.
- [ ] Commit.

### Task 2: Materialize the complete 600-case Java corpus and compile-safe support types

**Files:**
- Create: all 600 `scan-target/.../CaseNNNNNN.java`
- Create: `scan-target/.../support/*.java`
- Create: `build-harness/pom.xml`
- Create: `ground-truth/ground_truth.json`
- Create: `ground-truth/expected_results.csv`
- Create: `ground-truth/expected_counts.json`

**Interfaces:**
- Consumes: Task 1 case definitions.
- Produces: frozen v1 scan payload and matching ground truth.

- [ ] Add tests that compare generated records against materialized files and counts.
- [ ] Verify tests fail before materialization.
- [ ] Generate 600 Java files with no truth labels inside the scan payload.
- [ ] Generate ground truth and expected-count artifacts.
- [ ] Add a Maven harness that validates Java 17 syntax/types without executing vulnerable methods.
- [ ] Run corpus tests and Maven compile validation.
- [ ] Commit.

### Task 3: Ground-truth and anti-leakage validators

**Files:**
- Create: `tools/validate_ground_truth.py`
- Create: `tools/validate_cases.py`
- Create: `tests/test_ground_truth.py`

**Interfaces:**
- Produces CLI exit code 0 only when counts, uniqueness, references, path existence, line ranges, cohort distribution, and anti-leakage rules pass.

- [ ] Write failing tests for count mismatch, duplicate IDs, invalid CWE URL, missing rationale, missing file, forbidden truth markers, and non-neutral filenames.
- [ ] Implement validators.
- [ ] Verify tests pass.
- [ ] Run validators on full corpus.
- [ ] Commit.

### Task 4: XGuardian evaluator and scoring engine

**Files:**
- Create: `tools/benchmark_lib.py`
- Create: `tools/evaluate_xguardian.py`
- Create: `tests/test_evaluator.py`
- Create: `tests/fixtures/xguardian_known_result.json`

**Interfaces:**
- `evaluate_xguardian.py RESULT.json --ground-truth ground-truth/ground_truth.json --out results/<run>`
- Outputs `score.json`, `case_results.csv`, `findings_normalized.json`, `unmatched_findings.json`, `extraneous_findings.json`, `summary.md`.

- [ ] Write failing tests for path normalization, line normalization, exact dedupe, case matching, TP/TN/FP/FN, taxonomy exact/accepted scoring, duplicate rate, unmatched and extraneous findings.
- [ ] Implement normalized finding model and metric functions.
- [ ] Implement evaluator CLI and output writers.
- [ ] Run evaluator self-tests.
- [ ] Commit.

### Task 5: Before/after regression comparator

**Files:**
- Create: `tools/compare_runs.py`
- Extend: `tests/test_evaluator.py`

**Interfaces:**
- `compare_runs.py BEFORE/score.json AFTER/score.json --before-cases BEFORE/case_results.csv --after-cases AFTER/case_results.csv`
- Reports new/lost TP, fixed/new FP, fixed/new FN, overall deltas, CWE/difficulty deltas, taxonomy and duplicate changes.

- [ ] Write failing comparator tests.
- [ ] Implement comparison and Markdown/JSON output.
- [ ] Verify regression tests pass.
- [ ] Commit.

### Task 6: Full documentation and 30 CWE evidence pages

**Files:**
- Replace: `README.md`
- Create: `docs/METHODOLOGY.md`
- Create: `docs/SCORING.md`
- Create: `docs/XGUARDIAN_USAGE.md`
- Create: `docs/RULE_TUNING_GUIDE.md`
- Create: `docs/EXTERNAL_VALIDATION.md`
- Create: `docs/BASELINE.md`
- Create: `docs/REFERENCES.md`
- Create: `docs/CORPUS_CATALOG.md`
- Create: 30 files under `docs/cwe/`

**Interfaces:**
- README must make `scan-target/` unmistakable.
- CWE pages cite exact MITRE entries and describe benchmark-specific vulnerable/safe logic.
- References distinguish official authority from secondary implementation guidance.

- [ ] Document methodology, formulas, limitations, anti-overfitting, holdout policy, and XGuardian workflow.
- [ ] Document OWASP Benchmark v1.2 facts (2,740 cases, 11 categories, expected-results truth file).
- [ ] Document NIST Juliet Java 1.3 facts (28,881 cases, 112 CWEs, SARD).
- [ ] Document current MITRE 2025 CWE Top 25 context for selected high-risk weaknesses.
- [ ] Document GitHub CodeQL Java and SonarSource as secondary pattern references, not truth authorities.
- [ ] Create 30 CWE pages with exact official URLs and benchmark rationale.
- [ ] Commit.

### Task 7: CI, reproducibility, and repository hygiene

**Files:**
- Create: `.github/workflows/benchmark-validation.yml`
- Create: `.gitignore`
- Create: `LICENSE`
- Create: `results/.gitkeep`

**Interfaces:**
- CI runs Python tests, ground-truth validation, corpus validation, generator consistency check, and Maven compile validation.

- [ ] Add CI workflow.
- [ ] Add ignore rules for local result artifacts while retaining `.gitkeep`.
- [ ] Add license and provenance notes that original fixtures are authored for this repository and external benchmark material is referenced, not copied.
- [ ] Verify workflow syntax and commands.
- [ ] Commit.

### Task 8: Freeze v1 corpus and final audit

**Files:**
- Update: `benchmark_meta/reference_snapshot.json`
- Update: `docs/BASELINE.md`
- Update: `README.md` if final counts differ only due documented implementation corrections.

- [ ] Run exact-count audit: 600 total, 300 vulnerable, 300 safe, 20/CWE.
- [ ] Run anti-leakage audit across `scan-target/`.
- [ ] Run evaluator known-result self-test.
- [ ] Run generator/materialization consistency test.
- [ ] Run Maven compile-only validation.
- [ ] Confirm no real credential/token patterns.
- [ ] Record corpus version `v1.0.0` readiness; do not invent XGuardian baseline metrics before an actual scan.
- [ ] Commit.
