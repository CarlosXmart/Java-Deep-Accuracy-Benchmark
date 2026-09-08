# Security

This repository intentionally contains insecure Java examples for static-analysis benchmarking.

## Safe use

- Treat `scan-target/` as test material only.
- Do not deploy or expose the fixtures as an application.
- Do not execute vulnerable paths against untrusted input.
- Never add real credentials, API keys, access tokens, private keys, internal hostnames or private network addresses.
- Keep raw scanner outputs containing environment-specific data out of version control.

## Synthetic credentials

Some CWE cases require credential-like literals. Those values are intentionally synthetic and benchmark-only. Never replace them with real secrets.

## Reporting a repository hygiene issue

If a real secret or sensitive value is accidentally committed, rotate or revoke it first, then remove it from repository history.

Contact: carlos.gabriel@xmartsolutions.com.br
