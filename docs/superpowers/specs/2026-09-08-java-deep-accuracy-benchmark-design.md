# Java Deep Accuracy Benchmark — Design Specification

**Status:** Proposed design for implementation  
**Date:** 2026-09-08  
**Target:** XGuardian SAST Java accuracy/regression testing  
**Repository:** `CarlosXmart/Java-Deep-Accuracy-Benchmark`

## 1. Objective

Build a Java-only SAST accuracy benchmark that is substantially broader, harder, and more defensible than the current 20-case Java slice used by the XGuardian polyglot benchmark.

The benchmark is intended to support repeated rule tuning without losing sight of false positives, false negatives, CWE classification quality, duplicate findings, or regressions introduced by new rules.

The project is inspired by established public evaluation methodologies rather than by ad-hoc examples:

- **OWASP Benchmark for Java** — executable benchmark with thousands of test cases, known expected results, TP/FN/TN/FP scoring, CWE mapping, and an accuracy score based on `TPR - FPR`. Official project: <https://owasp.org/www-project-benchmark/>
- **NIST Juliet Java 1.3 / SARD** — 28,881 Java test cases across 112 CWEs, with good/bad flows and multiple control/data-flow variants. Official dataset: <https://samate.nist.gov/SARD/test-suites/111>
- **MITRE CWE** — authoritative weakness definitions and Java applicability references. CWE catalog: <https://cwe.mitre.org/>

The benchmark will not claim to represent absolute real-world accuracy. It is a controlled regression and calibration suite whose results become more meaningful when combined with a blind holdout and external benchmarks such as OWASP Benchmark and NIST Juliet.

---

## 2. Selected approach

### Recommended and approved direction: purpose-built XGuardian Java benchmark

Create an original Java corpus with neutral filenames, independent ground truth, progressive difficulty, paired positive/negative cases, explicit documentation, automated scoring, and regression comparison.

Why this approach:

1. It allows precise control over the exact Java patterns that XGuardian rules are being tuned against.
2. It makes false-positive behavior a first-class requirement rather than an afterthought.
3. It supports framework/context cases that are underrepresented in tiny synthetic snippets.
4. It keeps evaluation reproducible and independent of XGuardian's own result format through a normalized evaluator.
5. It can be cross-validated against OWASP Benchmark and NIST Juliet to reduce benchmark overfitting.

### Alternatives considered

**A. Reuse only OWASP Benchmark Java.** Strong external comparability, but limited to its current CWE families and older Java EE patterns. It does not give enough control for targeted XGuardian rule refinement.

**B. Reuse only NIST Juliet Java.** Extremely broad and useful for coverage, but much larger and more synthetic, with many patterns not aligned to the specific modern Java/framework behavior being tuned in XGuardian.

**C. Purpose-built benchmark + external validation.** Selected. Gives fine-grained rule-tuning feedback while preserving independent validation through OWASP/NIST.

---

## 3. Corpus scope

### Version 1 target

- **600 scored Java cases**
- **300 intentionally vulnerable**
- **300 intentionally safe / hard-negative**
- **30 CWE families**
- **20 cases per CWE**
  - 10 vulnerable
  - 10 safe/hard-negative
- **5 progressive difficulty levels**
- One primary scored security condition per case
- Neutral case names; no TP/TN/CWE clues inside the scan payload

This 50/50 construction is intentional for calibration and does not claim to reflect vulnerability prevalence in production applications.

---

## 4. Scan boundary — critical requirement

The only path intended for XGuardian SAST scanning is:

```text
scan-target/
```

**Nothing outside `scan-target/` should be packaged into the XGuardian scan.**

Do not scan:

```text
docs/
ground-truth/
tools/
results/
build-harness/
.github/
README.md
```

Reason: ground-truth metadata, CWE names, rationale text, expected outcomes, score tooling, and benchmark documentation must never be available to the SAST engine during evaluation.

---

## 5. Repository structure

```text
Java-Deep-Accuracy-Benchmark/
├── README.md
├── scan-target/
│   └── io/xguardian/javabench/
│       ├── cases/
│       │   ├── level1/
│       │   ├── level2/
│       │   ├── level3/
│       │   ├── level4/
│       │   └── level5/
│       └── support/
│
├── build-harness/
│   └── pom.xml
│
├── ground-truth/
│   ├── ground_truth.json
│   ├── expected_results.csv
│   └── expected_counts.json
│
├── docs/
│   ├── METHODOLOGY.md
│   ├── SCORING.md
│   ├── XGUARDIAN_USAGE.md
│   ├── RULE_TUNING_GUIDE.md
│   ├── BASELINE.md
│   ├── EXTERNAL_VALIDATION.md
│   └── cwe/
│       └── CWE-XXX.md
│
├── tools/
│   ├── evaluate_xguardian.py
│   ├── validate_ground_truth.py
│   ├── validate_cases.py
│   ├── compare_runs.py
│   └── selftest_evaluator.py
│
├── results/
│   └── .gitkeep
│
└── .github/
    └── workflows/
        └── benchmark-validation.yml
```

---

## 6. CWE coverage

Initial 30 CWE targets:

1. CWE-22 — Path Traversal
2. CWE-78 — OS Command Injection
3. CWE-79 — Cross-site Scripting
4. CWE-89 — SQL Injection
5. CWE-90 — LDAP Injection
6. CWE-94 — Code Injection
7. CWE-113 — HTTP Response Splitting
8. CWE-209 — Sensitive Information in Error Message
9. CWE-295 — Improper Certificate Validation
10. CWE-319 — Cleartext Transmission of Sensitive Information
11. CWE-321 — Use of Hard-coded Cryptographic Key
12. CWE-327 — Use of Broken or Risky Cryptographic Algorithm
13. CWE-328 — Use of Weak Hash
14. CWE-330 — Use of Insufficiently Random Values
15. CWE-347 — Improper Verification of Cryptographic Signature
16. CWE-352 — Cross-Site Request Forgery
17. CWE-400 — Uncontrolled Resource Consumption
18. CWE-434 — Unrestricted Upload of File with Dangerous Type
19. CWE-470 — Use of Externally-Controlled Input to Select Classes or Code
20. CWE-502 — Deserialization of Untrusted Data
21. CWE-532 — Insertion of Sensitive Information into Log File
22. CWE-601 — URL Redirection to Untrusted Site
23. CWE-611 — Improper Restriction of XML External Entity Reference
24. CWE-614 — Sensitive Cookie in HTTPS Session Without Secure Attribute
25. CWE-643 — Improper Neutralization of Data within XPath Expressions
26. CWE-798 — Use of Hard-coded Credentials
27. CWE-862 — Missing Authorization
28. CWE-918 — Server-Side Request Forgery
29. CWE-1004 — Sensitive Cookie Without HttpOnly Flag
30. CWE-1333 — Inefficient Regular Expression Complexity

Each CWE receives its own `docs/cwe/CWE-XXX.md` with:

- official MITRE definition link;
- benchmark interpretation;
- Java-relevant source/sink patterns;
- safe variants;
- vulnerable variants;
- hard-negative rationale;
- ambiguity notes;
- expected primary CWE and accepted aliases, where justified;
- references to OWASP/NIST cases when conceptually comparable.

No CWE will be considered proven solely because a scanner reports it.

---

## 7. Difficulty model

### Level 1 — direct / local

Source and sink in the same method with minimal indirection. Purpose: validate basic rule coverage.

### Level 2 — local data flow

Aliases, temporary variables, branches, simple transformations, or local sanitization. Purpose: ensure the rule distinguishes real flow from lexical presence.

### Level 3 — interprocedural

Source and sink across helper/service methods, getters/setters, wrappers, or multiple classes. Purpose: challenge cross-method reasoning.

### Level 4 — framework/context

Use realistic APIs and frameworks where feasible, including JDBC, Jakarta Servlet, Spring MVC/Security, Jackson, SnakeYAML, Java NIO, JCA/JCE, XPath/XML, `java.net`, and `HttpClient`.

### Level 5 — adversarial / hard-negative intensive

Multiple files, interfaces, lambdas, aliases, builders, sanitizers in separate methods, partial validation, allowlists, canonicalization, wrappers, and near-identical safe/vulnerable pairs.

Level 5 is explicitly designed to detect rules that only pattern-match dangerous APIs without understanding the surrounding safety condition.

---

## 8. Pairing philosophy

Where possible, vulnerable and safe cases should differ by one security-relevant property.

Example concept for command execution:

Vulnerable:

```java
new ProcessBuilder("sh", "-c", "echo " + user).start();
```

Safe/hard-negative:

```java
new ProcessBuilder(List.of("printf", "%s", user)).start();
```

The safe variant keeps untrusted input as a separate process argument and avoids shell interpretation.

This type of pair is mandatory because it exposes false-positive behavior from rules that treat any `ProcessBuilder` + user input as command injection.

---

## 9. Neutral naming and anti-leakage rules

Files inside the scan payload use neutral names:

```text
Case000001.java
Case000002.java
Case000003.java
...
```

The following must not appear in identifiers/comments inside `scan-target/` purely as benchmark labels:

- `TP`
- `TN`
- `FP`
- `FN`
- `VULNERABLE`
- `SAFE`
- `CWE-XXX`
- weakness names used only to reveal expected outcome

All expected-result information stays outside `scan-target/`.

The validation tooling must fail if benchmark labels or ground-truth markers leak into the scan payload.

---

## 10. Ground-truth schema

Each scored case will contain, at minimum:

```json
{
  "id": "JAV-000147",
  "path": "scan-target/io/xguardian/javabench/cases/level3/Case000147.java",
  "expected_vulnerable": true,
  "preferred_cwe": "CWE-89",
  "accepted_cwes": ["CWE-89"],
  "category": "SQL Injection",
  "difficulty": 3,
  "framework": "JDBC",
  "source": "method_parameter",
  "sink": "Statement.executeQuery",
  "dataflow": "interprocedural",
  "target_start_line": 18,
  "target_end_line": 23,
  "rationale": "Untrusted value reaches a dynamically constructed SQL statement without parameterization.",
  "official_reference": "https://cwe.mitre.org/data/definitions/89.html"
}
```

The schema must support safe cases equally well, including a specific explanation of why the code should **not** be reported.

---

## 11. Outcome definitions

### True Positive (TP)

The case is intentionally vulnerable and at least one XGuardian finding matches the scored region/category under the evaluator's documented matching policy.

### False Negative (FN)

The case is intentionally vulnerable and the XGuardian result does not contain an accepted matching finding.

### True Negative (TN)

The case is intentionally safe and XGuardian correctly produces no accepted security finding for the scored condition.

### False Positive (FP)

The case is intentionally safe, with its safety property documented, but XGuardian reports a finding matching the tested condition.

A duplicate finding is not an additional TP. Multiple findings for one vulnerable case are evaluated separately for duplication and taxonomy quality.

---

## 12. Detection and taxonomy are separate dimensions

The benchmark must not conflate "found a security issue" with "mapped the perfect CWE".

Two independent scores are required:

### Detection accuracy

Did the scanner detect the intentionally vulnerable condition?

### Taxonomy accuracy

For detected vulnerable cases, did it return the preferred or explicitly accepted CWE?

This prevents a valid detection with a neighboring/parent CWE from being mislabeled automatically as a complete detection failure while still making CWE quality measurable.

---

## 13. Metrics

Required overall metrics:

- TP
- TN
- FP
- FN
- Precision
- Recall / TPR
- FPR
- Specificity
- F1
- Accuracy
- Balanced Accuracy
- Matthews Correlation Coefficient (MCC)
- OWASP-style Benchmark Accuracy Score: `100 × (TPR - FPR)`
- Taxonomy exact accuracy
- Taxonomy accepted/family accuracy
- Duplicate finding rate
- Findings per detected case
- Extraneous findings
- Unmatched findings

Required breakdowns:

- by CWE;
- by difficulty;
- by framework/API;
- by source type;
- by sink type;
- by data-flow type;
- by vulnerable vs hard-negative family.

---

## 14. Evaluator behavior

`tools/evaluate_xguardian.py` will:

1. read XGuardian exported JSON;
2. normalize paths, including absolute engine paths into `scan-target/...`;
3. normalize line values to integers;
4. deduplicate findings consistently;
5. map each finding to the relevant benchmark case;
6. apply target-region matching;
7. score detection independently from taxonomy;
8. output machine-readable and human-readable summaries;
9. never inspect or infer expected outcome from the Java source file name.

Expected outputs:

```text
results/<run>/score.json
results/<run>/case_results.csv
results/<run>/findings_normalized.json
results/<run>/unmatched_findings.json
results/<run>/extraneous_findings.json
results/<run>/summary.md
```

---

## 15. Regression comparison

`tools/compare_runs.py` compares two evaluator outputs and reports:

- new TP;
- lost TP;
- fixed FP;
- new FP;
- fixed FN;
- new FN;
- metric deltas overall and by CWE/difficulty;
- taxonomy improvements/regressions;
- duplicate-rate changes.

A rule change must not be described as an accuracy improvement merely because recall increased. The comparison must show whether that gain was purchased by an unacceptable rise in FPR.

---

## 16. Regression gates

Default quality gates for a rule-tuning iteration:

1. No previously detected vulnerable case may silently become FN without explicit review.
2. No previously clean hard-negative may become FP without explicit review.
3. Overall `TPR - FPR` must not decrease.
4. CWE-specific improvement must be reported separately from global improvement.
5. Any accepted-CWE mapping change must be documented.
6. Evaluator self-tests and ground-truth validation must pass before scores are accepted.

The repository should support stricter thresholds later, but v1 avoids inventing arbitrary product-release gates before a full 600-case baseline exists.

---

## 17. Build strategy

The benchmark source code should be syntactically and semantically valid wherever practical, but the scan payload must remain independent from build metadata.

`build-harness/pom.xml` may expose `scan-target/` as a source directory for compilation/testing purposes without placing `pom.xml` inside the path sent to XGuardian.

Some framework-oriented cases may require dependency stubs or minimal support classes under `scan-target/.../support/`. Where full third-party dependencies would distort the SAST payload, small type-compatible local fixtures may be used, clearly documented outside the scan payload.

The benchmark must not execute dangerous operations as part of validation. Vulnerable snippets are static test fixtures; build/unit validation should avoid triggering network calls, shell commands, file destruction, deserialization payload execution, or similar side effects.

---

## 18. Documentation requirements

### `README.md`

Must answer immediately:

- what the project is;
- what it measures;
- **exactly which folder to scan: `scan-target/`;**
- what must not be scanned;
- how to export XGuardian JSON;
- how to score a run;
- how to compare before/after rule changes;
- how to interpret TP/TN/FP/FN;
- why the score is not an absolute production accuracy claim.

### `docs/METHODOLOGY.md`

Sampling model, case construction, difficulty model, ground-truth policy, anti-leakage controls, known limitations, and reproducibility.

### `docs/SCORING.md`

All metric formulas and matching rules.

### `docs/XGUARDIAN_USAGE.md`

Step-by-step XGuardian execution instructions, including scanning **only `scan-target/`**.

### `docs/RULE_TUNING_GUIDE.md`

Before/after workflow for modifying SAST rules without overfitting.

### `docs/EXTERNAL_VALIDATION.md`

How and why to validate XGuardian additionally against OWASP Benchmark Java and NIST Juliet Java.

### `docs/BASELINE.md`

Records benchmark version, XGuardian engine/rule versions, run identifier, configuration, and results. No baseline is populated until the completed 600-case corpus is actually scanned.

---

## 19. External validation

The custom benchmark is intentionally optimized for XGuardian engineering feedback, so it must not become the only evidence of scanner quality.

Recommended independent controls:

### OWASP Benchmark Java

Official OWASP documentation states that Java Benchmark v1.2 contains **2,740 test cases** across 11 vulnerability areas. Each test case has a known expected outcome and maps to a single CWE. OWASP's scoring philosophy explicitly evaluates TP, FN, TN, FP and uses `TPR - FPR` as its normalized Benchmark Accuracy Score.

Source: <https://owasp.org/www-project-benchmark/>

### NIST Juliet Java 1.3

NIST SARD lists **28,881 Java test cases across 112 CWEs**. Juliet includes good/bad sinks and numerous control/data-flow variants, making it useful as a broad independent SAST regression source.

Source: <https://samate.nist.gov/SARD/test-suites/111>

### MITRE CWE

CWE definitions are the reference point for weakness semantics. Benchmark documentation should link to the exact official CWE entry for every family used.

Source: <https://cwe.mitre.org/>

---

## 20. Overfitting controls

The benchmark must distinguish two corpus roles:

### Development set

Used during active rule tuning and visible to engineers.

### Holdout/blind set

A reserved subset whose expected outcomes should not be used to hand-tune individual rules.

Recommended v1 policy after all 600 cases are authored and validated:

- 450 development cases (75%)
- 150 holdout cases (25%)
- stratified by CWE, outcome, and difficulty where possible

The holdout ground truth can remain versioned for reproducibility but should not be consulted during ordinary per-rule tuning. A future stronger setup can move holdout truth to a separate controlled repository or CI secret artifact.

---

## 21. Current legacy reference

The previous small Java benchmark produced, after the recent refinement:

- TP = 10
- FN = 0
- FP = 1
- TN = 9
- Recall = 100%
- Precision = 90.9%
- F1 ≈ 95.2%
- Accuracy = 95%

This is historical context only. It must **not** be directly compared as if it were the same population as the future 600-case corpus.

---

## 22. Security and safety constraints

- No real credentials, API keys, tokens, or secrets in fixtures.
- Credential test cases use unmistakably synthetic benchmark-only values.
- No network-dependent validation.
- No test should require exploitation to prove the ground truth.
- No test runner should execute dangerous vulnerable paths.
- Ground-truth files must never be sent to XGuardian.
- CI must validate that `scan-target/` does not contain benchmark truth labels.

---

## 23. Verification before first baseline

Before the first official XGuardian run, the repository must prove:

1. Exactly 600 scored cases exist.
2. Exactly 300 are vulnerable and 300 safe.
3. Each of the 30 CWE families has 20 cases.
4. Case IDs and paths are unique.
5. Every case has a valid MITRE CWE reference.
6. Every safe case has an explicit safety rationale.
7. Every vulnerable case has an explicit vulnerability rationale.
8. No truth labels leak into `scan-target/`.
9. Java validation/build checks pass for the intended fixture model.
10. Evaluator self-tests pass.
11. Ground-truth validation passes.
12. A dry-run result fixture produces known TP/TN/FP/FN values.

Only after these checks should a baseline be called official.

---

## 24. Implementation sequence

1. Bootstrap repository documentation and validation tooling.
2. Define the machine-readable CWE/case manifest schema.
3. Implement evaluator and self-tests first.
4. Implement corpus generator/templates where deterministic generation is appropriate.
5. Author/review CWE families in batches, with positive/negative pair review.
6. Materialize all 600 Java cases.
7. Validate corpus counts, anti-leakage, and compilation/syntax.
8. Add XGuardian usage documentation and CI validation.
9. Freeze benchmark v1 corpus before rule-tuning baseline.
10. Run XGuardian only against `scan-target/`.
11. Export JSON and compute baseline.
12. Use `compare_runs.py` for subsequent rule changes.

---

## 25. Success criteria

The project is complete when:

- the 600-case corpus is present and validated;
- all 30 CWE documentation pages exist;
- safe/vulnerable rationale is complete for every case;
- the evaluator and regression comparator have passing self-tests;
- README and usage docs make `scan-target/` unambiguous;
- CI catches count/schema/anti-leakage regressions;
- no real secret exists anywhere in the repository;
- an engineer can run XGuardian, export JSON, score it, and compare two rule iterations without manually editing the ground truth.

This project should make SAST rule tuning measurable: a change is an improvement only when it improves detection quality without silently trading it for false-positive noise or taxonomy regressions.
