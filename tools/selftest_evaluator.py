#!/usr/bin/env python3
import json, tempfile, subprocess, pathlib, sys
# Structural smoke test: ground truth validators are the primary repository gate.
for script in ("tools/validate_ground_truth.py","tools/validate_cases.py"):
    r=subprocess.run([sys.executable,script])
    if r.returncode: raise SystemExit(r.returncode)
print("selftest: PASS")
