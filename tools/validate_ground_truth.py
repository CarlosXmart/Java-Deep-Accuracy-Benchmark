#!/usr/bin/env python3
import json, os, sys, collections
p=sys.argv[1] if len(sys.argv)>1 else "ground-truth/ground_truth.json"
data=json.load(open(p,encoding="utf-8")); cases=data["cases"]
errors=[]
ids=set(); paths=set()
for c in cases:
    if c["id"] in ids: errors.append("duplicate id "+c["id"])
    if c["path"] in paths: errors.append("duplicate path "+c["path"])
    ids.add(c["id"]); paths.add(c["path"])
    if not c["path"].startswith("scan-target/"): errors.append("outside scan-target "+c["path"])
    if c["start_line"]>c["end_line"]: errors.append("invalid region "+c["id"])
    if not os.path.exists(c["path"]): errors.append("missing file "+c["path"])
counts=collections.Counter((c["preferred_cwe"],c["expected_vulnerable"]) for c in cases)
if len(cases)!=600: errors.append(f"expected 600 cases, got {len(cases)}")
if sum(c["expected_vulnerable"] for c in cases)!=300: errors.append("expected 300 vulnerable")
if sum(not c["expected_vulnerable"] for c in cases)!=300: errors.append("expected 300 safe")
for cwe in {c["preferred_cwe"] for c in cases}:
    if counts[(cwe,True)]!=10 or counts[(cwe,False)]!=10:
        errors.append(f"{cwe} not balanced 10/10")
print(f"cases={len(cases)} errors={len(errors)}")
for e in errors[:100]: print("ERROR",e)
raise SystemExit(1 if errors else 0)
