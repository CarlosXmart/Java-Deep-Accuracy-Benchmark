#!/usr/bin/env python3
import argparse, json, math, os, re
from collections import defaultdict

def norm_path(p):
    p=str(p or "").replace("\\","/").lstrip("./")
    for marker in ("scan-target/","io/xguardian/javabench/"):
        i=p.find(marker)
        if i>=0:
            tail=p[i:]
            return tail if marker=="scan-target/" else "scan-target/"+tail
    return p

def norm_cwe(v):
    if v is None:return None
    m=re.search(r"(?:CWE[-_ ]?)?(\d+)",str(v),re.I)
    return f"CWE-{int(m.group(1))}" if m else None

def line_num(v):
    try:return int(v)
    except:return None

def load_findings(path):
    data=json.load(open(path,encoding="utf-8"))
    if isinstance(data,dict) and "vulnerabilidades" in data:
        raw=data["vulnerabilidades"]
        return [{"path":norm_path(x.get("arquivo")),"line":line_num(x.get("linha")),"cwe":norm_cwe(x.get("cwe")),"severity":x.get("severidade"),"raw":x} for x in raw]
    if isinstance(data,dict) and "runs" in data:
        out=[]
        for run in data.get("runs",[]):
            rules={r.get("id"):r for r in run.get("tool",{}).get("driver",{}).get("rules",[])}
            for result in run.get("results",[]):
                locs=result.get("locations",[])
                if not locs:continue
                loc=locs[0].get("physicalLocation",{})
                artifact=loc.get("artifactLocation",{}).get("uri")
                line=loc.get("region",{}).get("startLine")
                rid=result.get("ruleId");rule=rules.get(rid,{})
                props=rule.get("properties",{})
                cwe=props.get("cwe") or props.get("CWE") or rid
                out.append({"path":norm_path(artifact),"line":line_num(line),"cwe":norm_cwe(cwe),"severity":None,"raw":result})
        return out
    if isinstance(data,list):
        return [{"path":norm_path(x.get("arquivo") or x.get("file") or x.get("path")),"line":line_num(x.get("linha") or x.get("line")),"cwe":norm_cwe(x.get("cwe")),"severity":x.get("severity"),"raw":x} for x in data]
    raise SystemExit("Formato de resultados não reconhecido")

def div(a,b):return a/b if b else 0.0
def metrics(tp,fn,tn,fp):
    precision=div(tp,tp+fp);recall=div(tp,tp+fn);fpr=div(fp,fp+tn);specificity=div(tn,tn+fp)
    f1=div(2*precision*recall,precision+recall);acc=div(tp+tn,tp+tn+fp+fn);bal=(recall+specificity)/2
    den=math.sqrt((tp+fp)*(tp+fn)*(tn+fp)*(tn+fn));mcc=div(tp*tn-fp*fn,den)
    return {"TP":tp,"FN":fn,"TN":tn,"FP":fp,"precision":precision,"recall_tpr":recall,"false_positive_rate":fpr,
            "specificity":specificity,"f1":f1,"accuracy":acc,"balanced_accuracy":bal,"mcc":mcc,"owasp_style_score":100*(recall-fpr)}

def main():
    ap=argparse.ArgumentParser();ap.add_argument("--results",required=True);ap.add_argument("--ground-truth",default="ground-truth/ground_truth.json")
    ap.add_argument("--out",default="results/score.json");ap.add_argument("--set",choices=["all","calibration","holdout"],default="all")
    args=ap.parse_args()
    data=json.load(open(args.ground_truth,encoding="utf-8"));cases=data["cases"]
    if args.set!="all":cases=[c for c in cases if c["set"]==args.set]
    findings=load_findings(args.results);by_path=defaultdict(list)
    for f in findings:by_path[f["path"]].append(f)
    rows=[];tp=fn=tn=fp=tax_exact=tax_accept=tax_eval=0
    for c in cases:
        fs=[f for f in by_path.get(norm_path(c["path"]),[]) if f["line"] is None or c["start_line"]<=f["line"]<=c["end_line"]]
        detected=bool(fs)
        if c["expected_vulnerable"] and detected:outcome="TP";tp+=1
        elif c["expected_vulnerable"]:outcome="FN";fn+=1
        elif detected:outcome="FP";fp+=1
        else:outcome="TN";tn+=1
        exact=accepted=False
        if outcome=="TP":
            tax_eval+=1;cwes={f["cwe"] for f in fs if f["cwe"]}
            exact=c["preferred_cwe"] in cwes;accepted=bool(cwes.intersection(c["accepted_cwes"]))
            tax_exact+=int(exact);tax_accept+=int(accepted)
        rows.append({"id":c["id"],"pair_id":c["pair_id"],"path":c["path"],"set":c["set"],"difficulty":c["difficulty"],
          "preferred_cwe":c["preferred_cwe"],"category":c["category"],"expected_vulnerable":c["expected_vulnerable"],
          "outcome":outcome,"findings":len(fs),"taxonomy_exact":exact,"taxonomy_accepted":accepted})
    overall=metrics(tp,fn,tn,fp);overall["taxonomy_evaluated_tp"]=tax_eval;overall["taxonomy_exact_accuracy"]=div(tax_exact,tax_eval);overall["taxonomy_accepted_accuracy"]=div(tax_accept,tax_eval)
    raw=len(findings);unique={(f["path"],f["line"],f["cwe"]) for f in findings};overall["total_input_findings"]=raw;overall["unique_findings"]=len(unique);overall["duplicate_finding_rate"]=div(raw-len(unique),raw)
    targets={norm_path(c["path"]) for c in cases};overall["findings_outside_scored_files"]=sum(1 for f in findings if f["path"] not in targets)
    def grouped(field):
        out={}
        for val in sorted({str(r[field]) for r in rows}):
            rr=[r for r in rows if str(r[field])==val];d={k:sum(x["outcome"]==k for x in rr) for k in ("TP","FN","TN","FP")}
            out[val]=metrics(d["TP"],d["FN"],d["TN"],d["FP"])
        return out
    result={"overall":overall,"by_cwe":grouped("preferred_cwe"),"by_difficulty":grouped("difficulty"),"by_set":grouped("set"),"case_results":rows}
    os.makedirs(os.path.dirname(args.out) or ".",exist_ok=True);json.dump(result,open(args.out,"w",encoding="utf-8"),indent=2,ensure_ascii=False);print(json.dumps(overall,indent=2))
if __name__=="__main__":main()
