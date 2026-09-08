# CWE-22 — Path Traversal

## Fonte oficial

- MITRE: https://cwe.mitre.org/data/definitions/22.html
- CodeQL secundário: https://codeql.github.com/codeql-query-help/java/java-path-injection/
- Catálogo geral: https://cwe.mitre.org/

**Autoridade semântica:** MITRE CWE. CodeQL/SonarSource são auxiliares.

## Papel no benchmark

Esta CWE aparece na **MITRE 2025 CWE Top 25 na posição #6**.

- Casos: **20**
- Vulneráveis: **10**
- Seguros/hard-negatives: **10**
- IDs: `JAV-000001` a `JAV-000020`
- 4 casos por nível
- 1 holdout por nível

## Condição vulnerável testada

Path construído com dado externo sem containment após normalização.

## Hard-negative / controle esperado

Normalização + startsWith(base) ou allowlist de nome simples.

## O que este conjunto tenta separar

FP típico: alertar mesmo após containment real. FN típico: não seguir alias/helper/request até Files.

## Progressão

| Level | Característica |
|---|---|
| 1 | condição direta |
| 2 | alias/configuração intermediária |
| 3 | helper/interprocedural |
| 4 | framework/configuração contextual quando aplicável |
| 5 | Function/Supplier/wrapper/indirection |

Os mecanismos exatos podem variar porque CWE-22 pode ser uma fraqueza de taint flow, configuração ou validação de resultado.

## Scoring

### Vulnerável
Sem finding na região esperada → **FN**.

### Seguro
Qualquer finding na região esperada → **FP**.

### CWE
Se um caso vulnerável é detectado, a classificação é avaliada separadamente contra:

```text
preferred_cwe = CWE-22
```

## Limite do ground truth

A marcação segura se refere **somente à condição CWE-22 pontuada**. Não significa que o arquivo é certificado como seguro para outras CWEs.

## Revisão

Ao mudar uma rule relacionada a CWE-22:

1. execute before;
2. examine development;
3. altere a rule por semântica geral, nunca por Case ID;
4. execute os 600 casos;
5. confirme holdout;
6. revise FP/FN e taxonomy;
7. valide externamente quando a mudança for material.
