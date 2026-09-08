#!/usr/bin/env python3
import json, pathlib, re
data=json.load(open("ground-truth/ground_truth.json",encoding="utf-8"))
errors=[]
for c in data["cases"]:
    text=pathlib.Path(c["path"]).read_text(encoding="utf-8")
    low=text.lower()
    for forbidden in ("true positive","false positive","vulnerable case","safe case","expected_vulnerable"):
        if forbidden in low: errors.append(f"{c['id']}: leaked label {forbidden}")
    if "region:start" not in text or "region:end" not in text: errors.append(f"{c['id']}: missing neutral region markers")
print(f"checked={len(data['cases'])} errors={len(errors)}")
for e in errors[:100]: print("ERROR",e)
raise SystemExit(1 if errors else 0)
