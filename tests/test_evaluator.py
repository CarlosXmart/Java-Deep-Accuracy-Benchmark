import json
import math
import tempfile
import unittest
from pathlib import Path
import sys

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "tools"))

class EvaluatorContractTests(unittest.TestCase):
    def test_metrics_known_confusion_matrix(self):
        from benchmark_lib import metrics
        m = metrics(tp=8, tn=9, fp=1, fn=2)
        self.assertAlmostEqual(8/9, m["precision"])
        self.assertAlmostEqual(0.8, m["recall_tpr"])
        self.assertAlmostEqual(0.1, m["false_positive_rate"])
        self.assertAlmostEqual(16/19, m["f1"])

    def test_normalizes_xguardian_path_and_line(self):
        from benchmark_lib import normalize_path, normalize_line
        self.assertEqual("scan-target/io/xguardian/javabench/cases/level1/Case000001.java",
                         normalize_path("/tmp/scanner/scan-target/io/xguardian/javabench/cases/level1/Case000001.java"))
        self.assertEqual("scan-target/io/xguardian/javabench/cases/level1/Case000001.java",
                         normalize_path("io/xguardian/javabench/cases/level1/Case000001.java"))
        self.assertEqual(5, normalize_line("5"))

    def test_deduplicates_logically_identical_findings(self):
        from benchmark_lib import normalize_findings
        raw=[
          {"arquivo":"io/xguardian/javabench/cases/level1/Case000001.java","linha":"5","cwe":"CWE-89","id":1},
          {"arquivo":"io/xguardian/javabench/cases/level1/Case000001.java","linha":5,"cwe":"89","id":2},
        ]
        normalized, duplicates = normalize_findings(raw)
        self.assertEqual(1,len(normalized))
        self.assertEqual(1,duplicates)

    def test_mcc_zero_denominator_is_zero(self):
        from benchmark_lib import metrics
        self.assertEqual(0.0, metrics(tp=0,tn=4,fp=0,fn=0)["mcc"])

    def test_known_four_case_score(self):
        from benchmark_lib import extract_findings, normalize_findings, score_cases
        gt=json.loads((ROOT/"ground-truth"/"ground_truth.json").read_text(encoding="utf-8"))["cases"][:4]
        doc=json.loads((ROOT/"tests"/"fixtures"/"xguardian_known_result.json").read_text(encoding="utf-8"))
        raw=extract_findings(doc)
        norm,dupes=normalize_findings(raw)
        scored=score_cases(gt,norm,raw_finding_count=len(raw),duplicate_count=dupes,line_tolerance=2)
        self.assertEqual({"TP":1,"TN":1,"FP":1,"FN":1},{k:scored["overall"][k] for k in ("TP","TN","FP","FN")})

if __name__ == "__main__":
    unittest.main()
