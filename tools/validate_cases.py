#!/usr/bin/env python3
from __future__ import annotations
import json, re, sys
from pathlib import Path

ROOT=Path(__file__).resolve().parents[1]
SCAN=ROOT/"scan-target"
GT=ROOT/"ground-truth"/"ground_truth.json"
FORBIDDEN=re.compile(r"(?i)(CWE-\d+|\b(?:TP|TN|FP|FN)\b|VULNERABLE|HARD[-_ ]?NEGATIVE|EXPECTED[_ -]?VULNERABLE)")
SECRET_PATTERNS=[
    re.compile(r"AKIA[0-9A-Z]{16}"),
    re.compile(r"gh[pousr]_[A-Za-z0-9]{30,}"),
    re.compile(r"-----BEGIN (?:RSA |EC |OPENSSH )?PRIVATE KEY-----"),
    re.compile(r"eyJ[A-Za-z0-9_-]{10,}\.[A-Za-z0-9_-]{10,}\.[A-Za-z0-9_-]{10,}"),
]

def main():
    errors=[]
    gt=json.loads(GT.read_text(encoding="utf-8"))["cases"]
    expected={c["path"] for c in gt}
    actual={str(p.relative_to(ROOT)).replace("\\","/") for p in SCAN.rglob("Case*.java")}
    if len(actual)!=600: errors.append(f"expected 600 neutral case files, got {len(actual)}")
    missing=expected-actual; extra=actual-expected
    if missing: errors.append(f"missing files: {sorted(missing)[:10]}")
    if extra: errors.append(f"untracked case files: {sorted(extra)[:10]}")
    for path in SCAN.rglob("*.java"):
        text=path.read_text(encoding="utf-8")
        match=FORBIDDEN.search(text)
        if match: errors.append(f"{path.relative_to(ROOT)} leaks truth label {match.group(0)!r}")
        for pattern in SECRET_PATTERNS:
            if pattern.search(text): errors.append(f"{path.relative_to(ROOT)} matches real-secret pattern")
        if path.name.startswith("Case") and not re.fullmatch(r"Case\d{6}\.java",path.name):
            errors.append(f"non-neutral case filename: {path.name}")
    support=list((SCAN/"io/xguardian/javabench/support").glob("*.java"))
    if not support: errors.append("support package missing")
    if errors:
        for e in errors: print(f"ERROR: {e}",file=sys.stderr)
        return 1
    print("scan-payload validation: PASS (600 neutral cases; no truth-label leakage; no real-secret patterns)")
    return 0

if __name__=="__main__": raise SystemExit(main())
