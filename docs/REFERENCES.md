# Referências e evidência externa

**Snapshot de pesquisa:** 2026-09-08.

## Hierarquia usada

1. **MITRE CWE** — autoridade semântica da fraqueza.
2. **OWASP Benchmark / NIST SARD-Juliet** — referências de metodologia e corpus externo.
3. **GitHub CodeQL / SonarSource** — referências secundárias de implementação, source/sink, recomendações e cobertura de SAST.
4. Literatura/advisories adicionais — somente quando versionados e rastreáveis.

## OWASP Benchmark

https://owasp.org/www-project-benchmark/

Fatos usados:
- Java Benchmark v1.2;
- 2.740 casos;
- 11 áreas;
- cada caso é verdadeiro problema ou false-positive test para uma CWE;
- expected results em `expectedresults-VERSION#.csv`.

## NIST Juliet Java 1.3

https://samate.nist.gov/SARD/test-suites/111

Fatos usados:
- 28.881 casos;
- 112 CWEs;
- 73,2 MB;
- submission date 01 Oct 2017;
- NSA Center for Assured Software;
- disponibilizado pelo NIST SARD.

## MITRE CWE

Catálogo:
https://cwe.mitre.org/

2025 Top 25:
https://cwe.mitre.org/top25/archive/2025/2025_cwe_top25.html

Metodologia 2025:
https://cwe.mitre.org/top25/archive/2025/2025_methodology.html

A metodologia 2025 declara análise de **39.080 CVE Records** publicados de 01/06/2024 a 01/06/2025.

## GitHub CodeQL Java/Kotlin

Índice:
https://codeql.github.com/codeql-query-help/java/

Referências especialmente úteis ao corpus:

- CWE-22 Path injection: https://codeql.github.com/codeql-query-help/java/java-path-injection/
- CWE-78 Command line injection: https://codeql.github.com/codeql-query-help/java/java-command-line-injection/
- CWE-89 SQL injection: https://codeql.github.com/codeql-query-help/java/java-sql-injection/
- CWE-352 CSRF: https://codeql.github.com/codeql-query-help/java/java-csrf-unprotected-request-type/
- CWE-502 Unsafe deserialization: https://codeql.github.com/codeql-query-help/java/java-unsafe-deserialization/
- CWE-918 SSRF: https://codeql.github.com/codeql-query-help/java/java-ssrf/

CodeQL é evidência auxiliar; um comportamento não vira ground truth apenas porque CodeQL possui uma query.

## SonarSource Java

https://rules.sonarsource.com/java/

Usado como referência secundária de análise estática e rule design. Não é a fonte semântica primária das CWEs deste benchmark.

## Licenças/proveniência

O código dos 600 fixtures deste repositório é original. O projeto referencia documentação externa; não incorpora/copía o corpus OWASP ou Juliet.
