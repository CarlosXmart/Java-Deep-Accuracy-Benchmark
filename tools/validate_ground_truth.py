#!/usr/bin/env python3
from __future__ import annotations
import json, re, sys
from collections import Counter
from pathlib import Path

ROOT=Path(__file__).resolve().parents[1]
GT=ROOT/"ground-truth"/"ground_truth.json"
CAT=ROOT/"benchmark_meta"/"cwe_catalog.json"
COUNTS=ROOT/"ground-truth"/"expected_counts.json"

def fail(errors):
    for e in errors: print(f"ERROR: {e}",file=sys.stderr)
    raise SystemExit(1)

def main():
    errors=[]
    doc=json.loads(GT.read_text(encoding="utf-8"))
    cases=doc.get("cases",[])
    catalog=json.loads(CAT.read_text(encoding="utf-8"))
    catalog_ids={x["id"] for x in catalog["cwes"]}
    required={"id","path","expected_vulnerable","preferred_cwe","accepted_cwes","category","difficulty","framework","source","sink","dataflow","target_start_line","target_end_line","rationale","official_reference","cohort"}
    if len(cases)!=600: errors.append(f"expected 600 cases, got {len(cases)}")
    if sum(bool(c.get("expected_vulnerable")) for c in cases)!=300: errors.append("expected exactly 300 vulnerable cases")
    if sum(not bool(c.get("expected_vulnerable")) for c in cases)!=300: errors.append("expected exactly 300 safe cases")
    ids=[c.get("id") for c in cases]; paths=[c.get("path") for c in cases]
    if len(ids)!=len(set(ids)): errors.append("duplicate case IDs")
    if len(paths)!=len(set(paths)): errors.append("duplicate case paths")
    by_cwe=Counter(c.get("preferred_cwe") for c in cases)
    if len(by_cwe)!=30 or any(v!=20 for v in by_cwe.values()): errors.append(f"CWE distribution invalid: {dict(by_cwe)}")
    for cwe in by_cwe:
        subset=[c for c in cases if c.get("preferred_cwe")==cwe]
        if sum(bool(c.get("expected_vulnerable")) for c in subset)!=10: errors.append(f"{cwe}: vulnerable count != 10")
    by_level=Counter(c.get("difficulty") for c in cases)
    if dict(sorted(by_level.items()))!={1:120,2:120,3:120,4:120,5:120}: errors.append(f"difficulty distribution invalid: {dict(by_level)}")
    by_cohort=Counter(c.get("cohort") for c in cases)
    if by_cohort!={"development":450,"holdout":150}: errors.append(f"cohort distribution invalid: {dict(by_cohort)}")
    holdout=[c for c in cases if c.get("cohort")=="holdout"]
    if sum(bool(c.get("expected_vulnerable")) for c in holdout)!=75: errors.append("holdout must contain 75 vulnerable and 75 safe cases")

    for i,c in enumerate(cases,1):
        missing=required-set(c)
        if missing: errors.append(f"case {i} missing fields {sorted(missing)}"); continue
        if not re.fullmatch(r"JAV-\d{6}",str(c["id"])): errors.append(f"{c['id']}: invalid ID")
        if not re.fullmatch(r"scan-target/io/xguardian/javabench/cases/level[1-5]/Case\d{6}\.java",str(c["path"])): errors.append(f"{c['id']}: invalid neutral path")
        if c["preferred_cwe"] not in catalog_ids: errors.append(f"{c['id']}: CWE not in catalog")
        if c["preferred_cwe"] not in c["accepted_cwes"]: errors.append(f"{c['id']}: preferred CWE missing from accepted_cwes")
        number=c["preferred_cwe"].split("-")[-1]
        expected_ref=f"https://cwe.mitre.org/data/definitions/{int(number)}.html"
        if c["official_reference"]!=expected_ref: errors.append(f"{c['id']}: unexpected MITRE reference")
        if c["difficulty"] not in (1,2,3,4,5): errors.append(f"{c['id']}: invalid difficulty")
        if c["cohort"] not in ("development","holdout"): errors.append(f"{c['id']}: invalid cohort")
        if len(str(c["rationale"]).strip())<30: errors.append(f"{c['id']}: rationale too short")
        path=ROOT/c["path"]
        if not path.is_file(): errors.append(f"{c['id']}: source file missing"); continue
        lines=path.read_text(encoding="utf-8").splitlines()
        start,end=int(c["target_start_line"]),int(c["target_end_line"])
        if start<1 or end<start or end>len(lines): errors.append(f"{c['id']}: target region outside file")

    if "source_code" in json.dumps(doc): errors.append("ground truth must not embed source_code")
    expected_counts=json.loads(COUNTS.read_text(encoding="utf-8"))
    if expected_counts.get("total")!=600 or expected_counts.get("vulnerable")!=300 or expected_counts.get("safe")!=300:
        errors.append("expected_counts totals do not match contract")
    if errors: fail(errors)
    print("ground-truth validation: PASS (600 cases, 30 CWEs, 300/300, 150 holdout)")
    return 0

if __name__=="__main__": raise SystemExit(main())
