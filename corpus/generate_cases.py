#!/usr/bin/env python3
"""Materialize or verify the frozen benchmark corpus from corpus/definitions.json."""
from __future__ import annotations
import argparse, csv, json
from collections import Counter, defaultdict
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
DEFINITIONS = ROOT / "corpus" / "definitions.json"

def build_outputs():
    doc = json.loads(DEFINITIONS.read_text(encoding="utf-8"))
    cases = doc["cases"]
    gt_cases = [{k:v for k,v in c.items() if k != "source_code"} for c in cases]
    gt = {"schema_version":"1.0.0","benchmark_version":doc["benchmark_version"],"scan_path":"scan-target/","case_count":len(cases),"cases":gt_cases}
    counts = {"benchmark_version":doc["benchmark_version"],"total":len(cases),
              "vulnerable":sum(c["expected_vulnerable"] for c in cases),
              "safe":sum(not c["expected_vulnerable"] for c in cases),
              "by_cwe":{}, "by_difficulty":{}, "by_cohort":{}}
    for key, field in (("by_cwe","preferred_cwe"),("by_difficulty","difficulty"),("by_cohort","cohort")):
        groups=defaultdict(lambda: {"total":0,"vulnerable":0,"safe":0})
        for c in cases:
            g=groups[str(c[field])]
            g["total"] += 1
            g["vulnerable" if c["expected_vulnerable"] else "safe"] += 1
        counts[key]=dict(sorted(groups.items()))
    return cases, gt, counts

def render_csv(cases):
    cols=["id","path","expected_vulnerable","preferred_cwe","category","difficulty","variant","framework","source","sink","dataflow","cohort"]
    import io
    out=io.StringIO()
    w=csv.DictWriter(out,fieldnames=cols,extrasaction="ignore",quoting=csv.QUOTE_ALL,lineterminator="\n")
    w.writeheader(); w.writerows(cases)
    return out.getvalue()

def materialize(check=False):
    cases, gt, counts = build_outputs()
    expected = {
        ROOT/"ground-truth"/"ground_truth.json": json.dumps(gt,indent=2,ensure_ascii=False)+"\n",
        ROOT/"ground-truth"/"expected_counts.json": json.dumps(counts,indent=2,ensure_ascii=False,sort_keys=True)+"\n",
        ROOT/"ground-truth"/"expected_results.csv": render_csv(cases),
    }
    for case in cases:
        expected[ROOT/case["path"]] = case["source_code"]
    mismatches=[]
    for path,content in expected.items():
        if check:
            if not path.is_file() or path.read_text(encoding="utf-8") != content:
                mismatches.append(str(path.relative_to(ROOT)))
        else:
            path.parent.mkdir(parents=True,exist_ok=True)
            path.write_text(content,encoding="utf-8")
    if check and mismatches:
        raise SystemExit("Materialization drift:\n" + "\n".join(mismatches[:50]))
    print(f"{'Verified' if check else 'Materialized'} {len(cases)} cases")

if __name__ == "__main__":
    p=argparse.ArgumentParser()
    p.add_argument("--check",action="store_true")
    args=p.parse_args()
    materialize(check=args.check)
