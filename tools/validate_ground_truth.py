#!/usr/bin/env python3
import collections, json, pathlib, sys

p=sys.argv[1] if len(sys.argv)>1 else "ground-truth/ground_truth.json"
data=json.load(open(p,encoding="utf-8"))
cases=data["cases"]
errors=[]
ids=set();paths=set()

for c in cases:
    cid=c["id"]; path=c["path"]
    if cid in ids: errors.append("duplicate id "+cid)
    if path in paths: errors.append("duplicate path "+path)
    ids.add(cid); paths.add(path)
    if not path.startswith("scan-target/"): errors.append("outside scan-target "+path)
    fp=pathlib.Path(path)
    if not fp.exists():
        errors.append("missing file "+path); continue
    lines=fp.read_text(encoding="utf-8").splitlines()
    try:
        start_marker=lines.index("    // region:start")+1
        end_marker=lines.index("    // region:end")+1
    except ValueError:
        errors.append("missing region markers "+cid); continue
    expected_start=start_marker+1
    expected_end=end_marker-1
    if c["start_line"]!=expected_start or c["end_line"]!=expected_end:
        errors.append(f"region mismatch {cid}: gt={c['start_line']}-{c['end_line']} actual={expected_start}-{expected_end}")
    if expected_start>expected_end: errors.append("empty region "+cid)

if len(cases)!=600: errors.append(f"expected 600 cases, got {len(cases)}")
if sum(bool(c["expected_vulnerable"]) for c in cases)!=300: errors.append("expected 300 vulnerable")
if sum(not bool(c["expected_vulnerable"]) for c in cases)!=300: errors.append("expected 300 safe")
if sum(c["set"]=="calibration" for c in cases)!=420: errors.append("expected 420 calibration")
if sum(c["set"]=="holdout" for c in cases)!=180: errors.append("expected 180 holdout")

by_cwe=collections.Counter((c["preferred_cwe"],bool(c["expected_vulnerable"])) for c in cases)
for cwe in sorted({c["preferred_cwe"] for c in cases}):
    if by_cwe[(cwe,True)]!=10 or by_cwe[(cwe,False)]!=10:
        errors.append(f"{cwe} not balanced 10/10")

by_level=collections.Counter(c["difficulty"] for c in cases)
for level in range(1,6):
    if by_level[level]!=120: errors.append(f"level {level}: expected 120, got {by_level[level]}")

scanned_java={str(x).replace("\\","/") for x in pathlib.Path("scan-target").rglob("*.java")}
if scanned_java!=paths:
    for extra in sorted(scanned_java-paths): errors.append("unscored java file "+extra)
    for missing in sorted(paths-scanned_java): errors.append("ground-truth path not in java corpus "+missing)

print(f"cases={len(cases)} java_files={len(scanned_java)} cwes={len({c['preferred_cwe'] for c in cases})} errors={len(errors)}")
for e in errors[:200]: print("ERROR",e)
raise SystemExit(1 if errors else 0)
