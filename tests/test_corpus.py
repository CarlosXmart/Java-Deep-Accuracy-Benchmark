import json
import re
import unittest
from collections import Counter
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
GT = ROOT / "ground-truth" / "ground_truth.json"
SCAN = ROOT / "scan-target"

class CorpusContractTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.cases = json.loads(GT.read_text(encoding="utf-8"))["cases"]

    def test_exact_population(self):
        self.assertEqual(600, len(self.cases))
        self.assertEqual(300, sum(c["expected_vulnerable"] for c in self.cases))
        self.assertEqual(300, sum(not c["expected_vulnerable"] for c in self.cases))

    def test_exact_cwe_balance(self):
        by_cwe = Counter(c["preferred_cwe"] for c in self.cases)
        self.assertEqual(30, len(by_cwe))
        self.assertTrue(all(v == 20 for v in by_cwe.values()))
        for cwe in by_cwe:
            subset = [c for c in self.cases if c["preferred_cwe"] == cwe]
            self.assertEqual(10, sum(c["expected_vulnerable"] for c in subset))
            self.assertEqual(10, sum(not c["expected_vulnerable"] for c in subset))

    def test_five_levels_are_balanced(self):
        by_level = Counter(c["difficulty"] for c in self.cases)
        self.assertEqual({1:120, 2:120, 3:120, 4:120, 5:120}, dict(by_level))

    def test_holdout_is_stratified(self):
        holdout = [c for c in self.cases if c["cohort"] == "holdout"]
        self.assertEqual(150, len(holdout))
        self.assertEqual(75, sum(c["expected_vulnerable"] for c in holdout))
        self.assertEqual(75, sum(not c["expected_vulnerable"] for c in holdout))
        self.assertEqual({1:30, 2:30, 3:30, 4:30, 5:30}, dict(Counter(c["difficulty"] for c in holdout)))

    def test_neutral_unique_paths_and_ids(self):
        ids = [c["id"] for c in self.cases]
        paths = [c["path"] for c in self.cases]
        self.assertEqual(len(ids), len(set(ids)))
        self.assertEqual(len(paths), len(set(paths)))
        for case in self.cases:
            self.assertRegex(case["id"], r"^JAV-\d{6}$")
            self.assertRegex(Path(case["path"]).name, r"^Case\d{6}\.java$")
            self.assertTrue((ROOT / case["path"]).is_file())

    def test_scan_payload_contains_no_truth_labels(self):
        forbidden = re.compile(r"(?i)(CWE-\d+|\b(?:TP|TN|FP|FN)\b|VULNERABLE|HARD[-_ ]?NEGATIVE|EXPECTED[_ -]?VULNERABLE)")
        for path in SCAN.rglob("*.java"):
            text = path.read_text(encoding="utf-8")
            self.assertIsNone(forbidden.search(text), str(path))

if __name__ == "__main__":
    unittest.main()
