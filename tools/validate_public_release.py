#!/usr/bin/env python3
from __future__ import annotations
import re, sys
from pathlib import Path
ROOT=Path(__file__).resolve().parents[1]
TEXT_SUFFIXES={".md",".txt",".json",".csv",".py",".java",".xml",".yml",".yaml",".toml",".properties",".gradle",".kts",".gitignore"}
FORBIDDEN_TERMS=[re.compile(r"(?i)\bxguardian\b"),re.compile(r"(?i)\bxmartsolutions\b"),re.compile(r"(?i)\bxmart solutions\b"),re.compile(r"(?i)xguardianplatform\.io"),re.compile(r"(?i)XGUARDIAN_(?:TOKEN|APP_ID|TEAM_ID|LANGUAGES)")]
SECRET_PATTERNS=[re.compile(r"AKIA[0-9A-Z]{16}"),re.compile(r"gh[pousr]_[A-Za-z0-9]{30,}"),re.compile(r"-----BEGIN (?:RSA |EC |OPENSSH )?PRIVATE KEY-----"),re.compile(r"eyJ[A-Za-z0-9_-]{10,}\.[A-Za-z0-9_-]{10,}\.[A-Za-z0-9_-]{10,}"),re.compile(r"(?i)(?:api[_-]?key|client[_-]?secret|access[_-]?token)\s*[:=]\s*['\"][A-Za-z0-9_./+=-]{16,}['\"]")]
PRIVATE_IP=re.compile(r"\b(?:10(?:\.\d{1,3}){3}|192\.168(?:\.\d{1,3}){2}|172\.(?:1[6-9]|2\d|3[01])(?:\.\d{1,3}){2})\b")
FORBIDDEN_FILENAMES={".env",".env.local",".env.production","id_rsa","id_ed25519"}
FORBIDDEN_SUFFIXES={".pem",".p12",".pfx",".key"}
def main():
    errors=[]
    for path in ROOT.rglob("*"):
        if not path.is_file(): continue
        rel=path.relative_to(ROOT)
        if any(part in {".git","target","__pycache__",".venv","venv"} for part in rel.parts): continue
        if path.name in FORBIDDEN_FILENAMES or path.suffix.lower() in FORBIDDEN_SUFFIXES:
            errors.append(f"forbidden sensitive file type/name: {rel}"); continue
        if path.suffix.lower() not in TEXT_SUFFIXES and path.name!="LICENSE": continue
        try: text=path.read_text(encoding="utf-8")
        except UnicodeDecodeError: continue
        text=text.replace("carlos.gabriel@xmartsolutions.com.br","<allowed-contact-email>")
        for pattern in FORBIDDEN_TERMS:
            m=pattern.search(text)
            if m: errors.append(f"internal/vendor-specific marker {m.group(0)!r}: {rel}")
        for pattern in SECRET_PATTERNS:
            if pattern.search(text): errors.append(f"possible real secret pattern: {rel}")
        m=PRIVATE_IP.search(text)
        if m: errors.append(f"private IP {m.group(0)}: {rel}")
    if errors:
        for e in errors: print(f"ERROR: {e}",file=sys.stderr)
        return 1
    print("public-release validation: PASS")
    return 0
if __name__=="__main__": raise SystemExit(main())
