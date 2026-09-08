#!/usr/bin/env python3
from __future__ import annotations
import argparse, csv, json
from pathlib import Path
from benchmark_lib import extract_findings, normalize_findings, score_cases

def pct(value: float) -> str:
    return f"{value*100:.2f}%"

def write_summary(path: Path, score: dict) -> None:
    o=score["overall"]
    text=f"""# Java Deep Accuracy Benchmark — Result Summary

## Overall

| Metric | Value |
|---|---:|
| TP | {o['TP']} |
| TN | {o['TN']} |
| FP | {o['FP']} |
| FN | {o['FN']} |
| Precision | {pct(o['precision'])} |
| Recall / TPR | {pct(o['recall_tpr'])} |
| FPR | {pct(o['false_positive_rate'])} |
| Specificity | {pct(o['specificity'])} |
| F1 | {pct(o['f1'])} |
| Accuracy | {pct(o['accuracy'])} |
| Balanced Accuracy | {pct(o['balanced_accuracy'])} |
| MCC | {o['mcc']:.4f} |
| OWASP-style score (100 × (TPR - FPR)) | {o['owasp_style_score']:.2f} |
| Taxonomy exact accuracy on TP | {pct(o['taxonomy_exact_accuracy_on_tp'])} |
| Taxonomy accepted accuracy on TP | {pct(o['taxonomy_accepted_accuracy_on_tp'])} |
| Raw findings | {o['raw_findings']} |
| Normalized findings | {o['normalized_findings']} |
| Duplicate findings | {o['duplicate_findings']} |
| Extraneous findings | {o['extraneous_findings']} |
| Unmatched findings | {o['unmatched_findings']} |

> This is a controlled benchmark score, not an absolute production-accuracy claim.
"""
    path.write_text(text,encoding="utf-8")

def main() -> int:
    p=argparse.ArgumentParser(description="Score XGuardian Java SAST JSON against benchmark ground truth.")
    p.add_argument("result",type=Path)
    p.add_argument("--ground-truth",type=Path,default=Path("ground-truth/ground_truth.json"))
    p.add_argument("--out",type=Path,required=True)
    p.add_argument("--line-tolerance",type=int,default=2)
    args=p.parse_args()

    result_doc=json.loads(args.result.read_text(encoding="utf-8"))
    gt_doc=json.loads(args.ground_truth.read_text(encoding="utf-8"))
    raw=extract_findings(result_doc)
    normalized,duplicates=normalize_findings(raw)
    scored=score_cases(gt_doc["cases"],normalized,raw_finding_count=len(raw),duplicate_count=duplicates,line_tolerance=args.line_tolerance)

    args.out.mkdir(parents=True,exist_ok=True)
    score={k:v for k,v in scored.items() if k not in ("case_results","unmatched_findings","extraneous_findings")}
    (args.out/"score.json").write_text(json.dumps(score,indent=2,ensure_ascii=False)+"\n",encoding="utf-8")
    (args.out/"findings_normalized.json").write_text(json.dumps(normalized,indent=2,ensure_ascii=False)+"\n",encoding="utf-8")
    (args.out/"unmatched_findings.json").write_text(json.dumps(scored["unmatched_findings"],indent=2,ensure_ascii=False)+"\n",encoding="utf-8")
    (args.out/"extraneous_findings.json").write_text(json.dumps(scored["extraneous_findings"],indent=2,ensure_ascii=False)+"\n",encoding="utf-8")

    rows=scored["case_results"]
    fields=["id","path","preferred_cwe","category","difficulty","framework","source","sink","dataflow","cohort","expected_vulnerable","outcome","detected","matching_finding_count","observed_cwes","taxonomy_exact","taxonomy_accepted"]
    with (args.out/"case_results.csv").open("w",encoding="utf-8",newline="") as fh:
        w=csv.DictWriter(fh,fieldnames=fields)
        w.writeheader()
        for row in rows:
            serial=dict(row); serial["observed_cwes"]=";".join(row["observed_cwes"]); w.writerow(serial)
    write_summary(args.out/"summary.md",score)
    print(json.dumps(score["overall"],indent=2))
    return 0

if __name__=="__main__":
    raise SystemExit(main())
