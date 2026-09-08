# Validação externa

O Java Deep Accuracy Benchmark é deliberadamente especializado em refinar regras do XGuardian. Por isso, não deve ser a única fonte de validação.

## OWASP Benchmark for Java

Referência oficial: https://owasp.org/www-project-benchmark/

O projeto OWASP usa milhares de casos, expected results e scorecards de ferramentas. É útil como validação independente de classes comuns de vulnerabilidade web Java.

## NIST/NSA Juliet Java

Referência do dataset Java 1.3: https://samate.nist.gov/SARD/test-suites/111

A suíte Java 1.3 possui 28.881 casos organizados em 112 CWEs. A publicação do NIST descreve Juliet como uma coleção destinada ao teste de analisadores estáticos e outras ferramentas de software assurance.

## Estratégia recomendada

```text
Java Deep Accuracy Benchmark
    ↓ tuning fino / regressão interna

OWASP Benchmark
    ↓ validação independente orientada a AppSec web

NIST Juliet Java
    ↓ cobertura externa ampla de variantes/CWEs
```

Uma melhoria só deve ser apresentada como generalização quando houver evidência fora do corpus usado para tuning.
