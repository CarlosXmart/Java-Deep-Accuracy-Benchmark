#!/usr/bin/env python3
"""Materialize or verify the frozen benchmark corpus from corpus/definitions.json."""
from __future__ import annotations

import argparse
import json
from collections import defaultdict
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
DEFINITIONS = ROOT / "corpus" / "definitions.json"

CSV_COLUMNS = [
    "id", "path", "expected_vulnerable", "preferred_cwe", "category",
    "difficulty", "variant", "framework", "source", "sink", "dataflow", "cohort",
]

def build_outputs():
    doc = json.loads(DEFINITIONS.read_text(encoding="utf-8"))
    cases = doc["cases"]
    gt_cases = [{k: v for k, v in case.items() if k != "source_code"} for case in cases]
    gt = {
        "schema_version": "1.0.0",
        "benchmark_version": doc["benchmark_version"],
        "scan_path": "scan-target/",
        "case_count": len(cases),
        "cases": gt_cases,
    }
    counts = {
        "benchmark_version": doc["benchmark_version"],
        "total": len(cases),
        "vulnerable": sum(case["expected_vulnerable"] for case in cases),
        "safe": sum(not case["expected_vulnerable"] for case in cases),
        "by_cwe": {},
        "by_difficulty": {},
        "by_cohort": {},
    }
    for key, field in (
        ("by_cwe", "preferred_cwe"),
        ("by_difficulty", "difficulty"),
        ("by_cohort", "cohort"),
    ):
        groups = defaultdict(lambda: {"total": 0, "vulnerable": 0, "safe": 0})
        for case in cases:
            group = groups[str(case[field])]
            group["total"] += 1
            group["vulnerable" if case["expected_vulnerable"] else "safe"] += 1
        # Preserve the reviewed corpus ordering from definitions.json.
        counts[key] = dict(groups)
    return cases, gt, counts

def csv_value(value):
    if isinstance(value, bool):
        return "true" if value else "false"
    return str(value)

def csv_quote(value):
    return '"' + csv_value(value).replace('"', '""') + '"'

def render_csv(cases):
    lines = [",".join(CSV_COLUMNS)]
    for case in cases:
        lines.append(",".join(csv_quote(case[column]) for column in CSV_COLUMNS))
    return "\n".join(lines) + "\n"

def materialize(check=False):
    cases, gt, counts = build_outputs()
    expected = {
        ROOT / "ground-truth" / "ground_truth.json":
            json.dumps(gt, indent=2, ensure_ascii=False) + "\n",
        ROOT / "ground-truth" / "expected_counts.json":
            json.dumps(counts, indent=2, ensure_ascii=False) + "\n",
        ROOT / "ground-truth" / "expected_results.csv":
            render_csv(cases),
    }
    for case in cases:
        expected[ROOT / case["path"]] = case["source_code"]

    mismatches = []
    for path, generated in expected.items():
        if check:
            if not path.is_file() or path.read_text(encoding="utf-8") != generated:
                mismatches.append(str(path.relative_to(ROOT)))
        else:
            path.parent.mkdir(parents=True, exist_ok=True)
            path.write_text(generated, encoding="utf-8")

    if check and mismatches:
        raise SystemExit("Materialization drift:\n" + "\n".join(mismatches[:50]))
    print(f"{'Verified' if check else 'Materialized'} {len(cases)} cases")

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--check", action="store_true")
    args = parser.parse_args()
    materialize(check=args.check)
