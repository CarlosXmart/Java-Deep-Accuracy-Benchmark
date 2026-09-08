# Validação externa

O benchmark próprio deve ser acompanhado por conjuntos independentes para reduzir overfitting.

## OWASP Benchmark for Java

Fonte oficial: https://owasp.org/www-project-benchmark/

A documentação da versão 1.2 apresenta **2.740 test cases** distribuídos por 11 áreas, incluindo Command Injection, Weak Cryptography, Weak Hashing, LDAP Injection, Path Traversal, Secure Cookie Flag, SQL Injection, Trust Boundary Violation, Weak Randomness, XPath Injection e XSS.

A OWASP distribui expected results por caso.

### Uso recomendado

- não copie expected results para rules;
- rode target SAST scanner no benchmark oficial separadamente;
- adapte o resultado do scanner para o formato esperado pelo evaluator oficial da OWASP quando fizer comparação externa;
- reporte versão exata.

## NIST SARD / Juliet Java 1.3

Fonte oficial: https://samate.nist.gov/SARD/test-suites/111

O NIST informa:
- 28.881 test cases;
- 112 CWEs;
- 73,2 MB;
- Java;
- submission date 2017-10-01;
- author: NSA Center for Assured Software.

### Uso recomendado

Juliet é especialmente útil para testar variações de control/data flow em escala. Não use a nota do corpus target SAST scanner como substituta do resultado em Juliet.

## Triangulação

Uma mudança significativa de rules Java deveria idealmente ser avaliada em:

1. Java Deep Accuracy Benchmark — development;
2. Java Deep Accuracy Benchmark — holdout;
3. OWASP Benchmark Java;
4. subconjunto relevante do NIST Juliet;
5. aplicações reais controladas.

## Comparabilidade

Nunca some os denominadores como se todos os casos fossem amostras independentes da mesma população. Reporte cada suíte separadamente.
