#!/usr/bin/env python3
from __future__ import annotations

import math
from collections import defaultdict
from pathlib import Path
from typing import Any, Iterable

SCAN_PREFIX = "scan-target/"
JAVA_PREFIX = "io/xguardian/javabench/"

def safe_div(num: float, den: float) -> float:
    return num / den if den else 0.0

def normalize_cwe(value: Any) -> str:
    if value is None:
        return ""
    if isinstance(value, bool):
        return ""
    if isinstance(value, int):
        return f"CWE-{value}"
    text = str(value).strip().upper()
    if not text:
        return ""
    if text.startswith("CWE-"):
        tail = text[4:].strip()
    else:
        tail = text
    digits = "".join(ch for ch in tail if ch.isdigit())
    return f"CWE-{int(digits)}" if digits else text

def normalize_line(value: Any) -> int | None:
    if value is None or value == "":
        return None
    if isinstance(value, bool):
        return None
    try:
        return int(float(str(value).strip()))
    except (ValueError, TypeError):
        return None

def normalize_path(value: Any) -> str:
    if value is None:
        return ""
    text = str(value).strip().replace("\\", "/")
    if text.startswith("file://"):
        text = text[7:]
    while text.startswith("./"):
        text = text[2:]
    marker = text.find(SCAN_PREFIX)
    if marker >= 0:
        return text[marker:]
    marker = text.find(JAVA_PREFIX)
    if marker >= 0:
        return SCAN_PREFIX + text[marker:]
    return text.lstrip("/")

def extract_findings(document: Any) -> list[dict[str, Any]]:
    if isinstance(document, list):
        return [x for x in document if isinstance(x, dict)]
    if not isinstance(document, dict):
        return []
    for key in ("vulnerabilidades", "findings", "results", "issues"):
        value = document.get(key)
        if isinstance(value, list):
            return [x for x in value if isinstance(x, dict)]
    return []

def _pick(raw: dict[str, Any], *keys: str) -> Any:
    for key in keys:
        if key in raw and raw[key] is not None:
            return raw[key]
    return None

def normalize_findings(raw_findings: Iterable[dict[str, Any]]) -> tuple[list[dict[str, Any]], int]:
    normalized: list[dict[str, Any]] = []
    seen: set[tuple[str, int | None, str]] = set()
    duplicates = 0
    for raw in raw_findings:
        path = normalize_path(_pick(raw, "arquivo", "path", "file", "uri", "filename"))
        line = normalize_line(_pick(raw, "linha", "line", "startLine", "start_line"))
        cwe = normalize_cwe(_pick(raw, "cwe", "CWE", "weakness"))
        item = {
            "path": path,
            "line": line,
            "cwe": cwe,
            "severity": str(_pick(raw, "severidade", "severity", "level") or ""),
            "name": str(_pick(raw, "nome", "name", "title", "ruleId") or ""),
            "language": str(_pick(raw, "linguagem", "language") or ""),
            "original_id": _pick(raw, "id", "finding_id"),
        }
        key = (path, line, cwe)
        if key in seen:
            duplicates += 1
            continue
        seen.add(key)
        normalized.append(item)
    return normalized, duplicates

def metrics(*, tp: int, tn: int, fp: int, fn: int) -> dict[str, float | int]:
    precision = safe_div(tp, tp + fp)
    recall = safe_div(tp, tp + fn)
    fpr = safe_div(fp, fp + tn)
    specificity = safe_div(tn, tn + fp)
    f1 = safe_div(2 * precision * recall, precision + recall)
    accuracy = safe_div(tp + tn, tp + tn + fp + fn)
    balanced = (recall + specificity) / 2 if (tp + fn and tn + fp) else 0.0
    denominator = math.sqrt((tp + fp) * (tp + fn) * (tn + fp) * (tn + fn))
    mcc = safe_div(tp * tn - fp * fn, denominator)
    return {
        "TP": tp, "TN": tn, "FP": fp, "FN": fn,
        "precision": precision,
        "recall_tpr": recall,
        "false_positive_rate": fpr,
        "specificity": specificity,
        "f1": f1,
        "accuracy": accuracy,
        "balanced_accuracy": balanced,
        "mcc": mcc,
        "owasp_style_score": 100.0 * (recall - fpr),
    }

def _in_region(finding: dict[str, Any], case: dict[str, Any], tolerance: int) -> bool:
    line = finding.get("line")
    if line is None:
        return False
    lo = int(case["target_start_line"]) - tolerance
    hi = int(case["target_end_line"]) + tolerance
    return lo <= line <= hi

def _aggregate_case_rows(rows: list[dict[str, Any]]) -> dict[str, Any]:
    tp=sum(r["outcome"]=="TP" for r in rows)
    tn=sum(r["outcome"]=="TN" for r in rows)
    fp=sum(r["outcome"]=="FP" for r in rows)
    fn=sum(r["outcome"]=="FN" for r in rows)
    result=metrics(tp=tp,tn=tn,fp=fp,fn=fn)
    detected=[r for r in rows if r["outcome"]=="TP"]
    result["taxonomy_evaluated_tp"]=len(detected)
    result["taxonomy_exact_correct_tp"]=sum(bool(r["taxonomy_exact"]) for r in detected)
    result["taxonomy_accepted_correct_tp"]=sum(bool(r["taxonomy_accepted"]) for r in detected)
    result["taxonomy_exact_accuracy_on_tp"]=safe_div(result["taxonomy_exact_correct_tp"], len(detected))
    result["taxonomy_accepted_accuracy_on_tp"]=safe_div(result["taxonomy_accepted_correct_tp"], len(detected))
    return result

def _breakdown(rows: list[dict[str, Any]], field: str) -> dict[str, Any]:
    groups: dict[str, list[dict[str, Any]]] = defaultdict(list)
    for row in rows:
        groups[str(row[field])].append(row)
    return {key:_aggregate_case_rows(value) for key,value in sorted(groups.items())}

def score_cases(
    ground_truth_cases: list[dict[str, Any]],
    findings: list[dict[str, Any]],
    *,
    raw_finding_count: int | None = None,
    duplicate_count: int = 0,
    line_tolerance: int = 2,
) -> dict[str, Any]:
    by_path: dict[str, list[dict[str, Any]]] = defaultdict(list)
    gt_by_path={normalize_path(c["path"]):c for c in ground_truth_cases}
    for finding in findings:
        by_path[normalize_path(finding.get("path"))].append(finding)

    rows=[]
    extraneous=[]
    unmatched=[]
    target_finding_count=0

    for finding in findings:
        path=normalize_path(finding.get("path"))
        case=gt_by_path.get(path)
        if case is None:
            unmatched.append(finding)
        elif not _in_region(finding, case, line_tolerance):
            extraneous.append(finding)

    for case in ground_truth_cases:
        path=normalize_path(case["path"])
        local=by_path.get(path, [])
        matching=[f for f in local if _in_region(f, case, line_tolerance)]
        target_finding_count += len(matching)
        expected=bool(case["expected_vulnerable"])
        detected=bool(matching)
        outcome=("TP" if detected else "FN") if expected else ("FP" if detected else "TN")
        observed=sorted({f["cwe"] for f in matching if f.get("cwe")})
        preferred=normalize_cwe(case["preferred_cwe"])
        accepted={normalize_cwe(x) for x in case.get("accepted_cwes", [preferred])}
        rows.append({
            "id":case["id"], "path":path, "preferred_cwe":preferred,
            "category":case["category"], "difficulty":case["difficulty"],
            "framework":case["framework"], "source":case["source"], "sink":case["sink"],
            "dataflow":case["dataflow"], "cohort":case["cohort"],
            "expected_vulnerable":expected, "outcome":outcome, "detected":detected,
            "matching_finding_count":len(matching), "observed_cwes":observed,
            "taxonomy_exact": expected and detected and preferred in observed,
            "taxonomy_accepted": expected and detected and bool(accepted.intersection(observed)),
        })

    overall=_aggregate_case_rows(rows)
    raw_count = len(findings)+duplicate_count if raw_finding_count is None else raw_finding_count
    overall.update({
        "raw_findings":raw_count,
        "normalized_findings":len(findings),
        "duplicate_findings":duplicate_count,
        "duplicate_rate":safe_div(duplicate_count, raw_count),
        "target_region_findings":target_finding_count,
        "findings_per_detected_vulnerable_case":safe_div(target_finding_count, overall["TP"]),
        "unmatched_findings":len(unmatched),
        "extraneous_findings":len(extraneous),
        "line_tolerance":line_tolerance,
    })
    return {
        "overall":overall,
        "by_cwe":_breakdown(rows,"preferred_cwe"),
        "by_difficulty":_breakdown(rows,"difficulty"),
        "by_framework":_breakdown(rows,"framework"),
        "by_cohort":_breakdown(rows,"cohort"),
        "by_dataflow":_breakdown(rows,"dataflow"),
        "case_results":rows,
        "unmatched_findings":unmatched,
        "extraneous_findings":extraneous,
    }
