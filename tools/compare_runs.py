#!/usr/bin/env python3
from __future__ import annotations
import argparse, csv, json
from pathlib import Path

def load_rows(path: Path):
    with path.open(encoding="utf-8",newline="") as fh:
        return {row["id"]:row for row in csv.DictReader(fh)}

def delta(a,b): return b-a

def main():
    p=argparse.ArgumentParser(description="Compare two Java benchmark evaluator runs.")
    p.add_argument("before_score",type=Path)
    p.add_argument("after_score",type=Path)
    p.add_argument("--before-cases",type=Path)
    p.add_argument("--after-cases",type=Path)
    p.add_argument("--out",type=Path)
    args=p.parse_args()
    before=json.loads(args.before_score.read_text(encoding="utf-8"))
    after=json.loads(args.after_score.read_text(encoding="utf-8"))
    bc=args.before_cases or args.before_score.with_name("case_results.csv")
    ac=args.after_cases or args.after_score.with_name("case_results.csv")
    br,ar=load_rows(bc),load_rows(ac)
    shared=sorted(set(br)&set(ar))
    transitions=[]
    for cid in shared:
        old,new=br[cid]["outcome"],ar[cid]["outcome"]
        if old!=new: transitions.append({"id":cid,"before":old,"after":new,"cwe":ar[cid]["preferred_cwe"],"difficulty":int(ar[cid]["difficulty"])})
    fixed_fp=[x for x in transitions if x["before"]=="FP" and x["after"]=="TN"]
    new_fp=[x for x in transitions if x["before"]=="TN" and x["after"]=="FP"]
    fixed_fn=[x for x in transitions if x["before"]=="FN" and x["after"]=="TP"]
    new_fn=[x for x in transitions if x["before"]=="TP" and x["after"]=="FN"]
    bo,ao=before["overall"],after["overall"]
    keys=["precision","recall_tpr","false_positive_rate","f1","accuracy","balanced_accuracy","mcc","owasp_style_score","taxonomy_exact_accuracy_on_tp","taxonomy_accepted_accuracy_on_tp","duplicate_rate"]
    metric_delta={k:delta(float(bo.get(k,0)),float(ao.get(k,0))) for k in keys}
    report={"fixed_fp":fixed_fp,"new_fp":new_fp,"fixed_fn":fixed_fn,"new_fn":new_fn,"all_outcome_transitions":transitions,"metric_delta":metric_delta,
            "before_confusion":{k:bo[k] for k in ("TP","TN","FP","FN")},"after_confusion":{k:ao[k] for k in ("TP","TN","FP","FN")}}
    lines=["# Benchmark Run Comparison","",
           f"- Fixed FP: **{len(fixed_fp)}**",f"- New FP: **{len(new_fp)}**",f"- Fixed FN: **{len(fixed_fn)}**",f"- New FN: **{len(new_fn)}**",
           f"- Recall delta: **{metric_delta['recall_tpr']*100:+.2f} p.p.**",f"- FPR delta: **{metric_delta['false_positive_rate']*100:+.2f} p.p.**",
           f"- F1 delta: **{metric_delta['f1']*100:+.2f} p.p.**",f"- OWASP-style score delta: **{metric_delta['owasp_style_score']:+.2f}**",""]
    markdown="\n".join(lines)
    if args.out:
        args.out.mkdir(parents=True,exist_ok=True)
        (args.out/"comparison.json").write_text(json.dumps(report,indent=2,ensure_ascii=False)+"\n",encoding="utf-8")
        (args.out/"comparison.md").write_text(markdown+"\n",encoding="utf-8")
    print(markdown)
    return 0

if __name__=="__main__": raise SystemExit(main())
