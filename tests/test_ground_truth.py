import json
import unittest
from pathlib import Path
from urllib.parse import urlparse

ROOT = Path(__file__).resolve().parents[1]
GT = ROOT / "ground-truth" / "ground_truth.json"

class GroundTruthTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.doc = json.loads(GT.read_text(encoding="utf-8"))
        cls.cases = cls.doc["cases"]

    def test_schema_version(self):
        self.assertEqual("1.0.0", self.doc["schema_version"])

    def test_every_case_has_evidence_and_valid_region(self):
        required = {
            "id","path","expected_vulnerable","preferred_cwe","accepted_cwes",
            "category","difficulty","framework","source","sink","dataflow",
            "target_start_line","target_end_line","rationale","official_reference","cohort"
        }
        for case in self.cases:
            self.assertTrue(required.issubset(case), case.get("id"))
            self.assertTrue(case["rationale"].strip())
            self.assertLessEqual(case["target_start_line"], case["target_end_line"])
            url = urlparse(case["official_reference"])
            self.assertEqual("https", url.scheme)
            self.assertEqual("cwe.mitre.org", url.netloc)
            self.assertIn(case["preferred_cwe"], case["accepted_cwes"])

    def test_reference_catalog_has_30_cwes(self):
        catalog = json.loads((ROOT/"benchmark_meta"/"cwe_catalog.json").read_text(encoding="utf-8"))
        self.assertEqual(30, len(catalog["cwes"]))

if __name__ == "__main__":
    unittest.main()
