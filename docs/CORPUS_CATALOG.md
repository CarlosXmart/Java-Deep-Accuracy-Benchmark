# Catálogo do corpus

Todos os itens abaixo têm **20 casos: 10 vulneráveis + 10 hard-negatives**, distribuídos igualmente nos 5 níveis.

| CWE | Categoria | MITRE Top 25 2025 | Casos | Contextos no corpus | Detalhe |
|---|---|---:|---:|---|---|
| CWE-22 | Path Traversal | #6 | 20 | JDK, Jakarta Servlet | [doc](cwe/CWE-22.md) |
| CWE-78 | OS Command Injection | #9 | 20 | JDK, Jakarta Servlet | [doc](cwe/CWE-78.md) |
| CWE-79 | Cross-site Scripting | #1 | 20 | Jakarta Servlet, Jakarta Servlet request flow | [doc](cwe/CWE-79.md) |
| CWE-89 | SQL Injection | #2 | 20 | JDBC | [doc](cwe/CWE-89.md) |
| CWE-90 | LDAP Injection | — | 20 | JNDI / LDAP | [doc](cwe/CWE-90.md) |
| CWE-94 | Code Injection | #10 | 20 | JDK Scripting | [doc](cwe/CWE-94.md) |
| CWE-113 | HTTP Response Splitting | — | 20 | Jakarta Servlet | [doc](cwe/CWE-113.md) |
| CWE-209 | Sensitive Error Message | — | 20 | Jakarta Servlet, Jakarta Servlet request flow | [doc](cwe/CWE-209.md) |
| CWE-295 | Certificate Validation | — | 20 | JSSE | [doc](cwe/CWE-295.md) |
| CWE-319 | Cleartext Transmission | — | 20 | java.net / java.net.http, Jakarta Servlet + java.net | [doc](cwe/CWE-319.md) |
| CWE-321 | Hard-coded Cryptographic Key | — | 20 | JCA/JCE | [doc](cwe/CWE-321.md) |
| CWE-327 | Broken/Risky Cryptography | — | 20 | JCA/JCE | [doc](cwe/CWE-327.md) |
| CWE-328 | Weak Hash | — | 20 | JCA | [doc](cwe/CWE-328.md) |
| CWE-330 | Insufficient Randomness | — | 20 | JDK | [doc](cwe/CWE-330.md) |
| CWE-347 | Signature Verification | — | 20 | JCA | [doc](cwe/CWE-347.md) |
| CWE-352 | CSRF | #3 | 20 | Jakarta Servlet | [doc](cwe/CWE-352.md) |
| CWE-400 | Uncontrolled Resource Consumption | — | 20 | JDK | [doc](cwe/CWE-400.md) |
| CWE-434 | Dangerous File Upload | #12 | 20 | java.nio.file, Jakarta Servlet metadata + java.nio.file | [doc](cwe/CWE-434.md) |
| CWE-470 | Unsafe Reflection | — | 20 | Java Reflection | [doc](cwe/CWE-470.md) |
| CWE-502 | Unsafe Deserialization | #15 | 20 | Java serialization, Jakarta Servlet + Java serialization | [doc](cwe/CWE-502.md) |
| CWE-532 | Sensitive Logging | — | 20 | java.util.logging, Jakarta Servlet + java.util.logging | [doc](cwe/CWE-532.md) |
| CWE-601 | Open Redirect | — | 20 | Jakarta Servlet | [doc](cwe/CWE-601.md) |
| CWE-611 | XML External Entity | — | 20 | JAXP | [doc](cwe/CWE-611.md) |
| CWE-614 | Cookie Secure Flag | — | 20 | Jakarta Servlet | [doc](cwe/CWE-614.md) |
| CWE-643 | XPath Injection | — | 20 | JAXP XPath | [doc](cwe/CWE-643.md) |
| CWE-798 | Hard-coded Credentials | — | 20 | JDK configuration | [doc](cwe/CWE-798.md) |
| CWE-862 | Missing Authorization | #4 | 20 | Application authorization, Jakarta Servlet | [doc](cwe/CWE-862.md) |
| CWE-918 | SSRF | #22 | 20 | java.net.http | [doc](cwe/CWE-918.md) |
| CWE-1004 | Cookie HttpOnly Flag | — | 20 | Jakarta Servlet | [doc](cwe/CWE-1004.md) |
| CWE-1333 | Regular Expression DoS | — | 20 | java.util.regex | [doc](cwe/CWE-1333.md) |

## Seleção

O conjunto não é uma cópia da Top 25. Ele combina:

- fraquezas de alta relevância atual;
- áreas históricas do OWASP Benchmark Java;
- categorias presentes/relacionadas ao NIST Juliet;
- padrões Java relevantes para SAST moderno;
- casos necessários para medir hard-negatives/contexto.

## Quantidade

```text
30 CWE × 20 = 600
30 CWE × 10 vulneráveis = 300
30 CWE × 10 seguros = 300
```

Para a fonte oficial de cada CWE, consulte `benchmark_meta/cwe_catalog.json` e `docs/cwe/`.
