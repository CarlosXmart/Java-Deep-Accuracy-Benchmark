#!/usr/bin/env python3
import json, sys
if len(sys.argv)!=3:
    raise SystemExit("uso: compare_runs.py before.json after.json")
a=json.load(open(sys.argv[1],encoding="utf-8")); b=json.load(open(sys.argv[2],encoding="utf-8"))
ao=a["overall"]; bo=b["overall"]
keys=["TP","FN","TN","FP","precision","recall_tpr","false_positive_rate","f1","accuracy","balanced_accuracy","mcc","taxonomy_exact_accuracy"]
print("Métrica\tAntes\tDepois\tDelta")
for k in keys:
    av=ao.get(k,0); bv=bo.get(k,0)
    print(f"{k}\t{av:.6f}" if isinstance(av,float) else f"{k}\t{av}", end="\t")
    print(f"{bv:.6f}" if isinstance(bv,float) else f"{bv}", end="\t")
    try: print(f"{bv-av:+.6f}")
    except TypeError: print("-")
print("\nRegressões por CWE:")
for cwe, old in a.get("by_cwe",{}).items():
    new=b.get("by_cwe",{}).get(cwe)
    if not new: continue
    if new["FN"]>old["FN"] or new["FP"]>old["FP"]:
        print(f"- {cwe}: FN {old['FN']}→{new['FN']} | FP {old['FP']}→{new['FP']}")
