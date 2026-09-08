# Guia de refinamento de rules SAST

## Objetivo

Usar o benchmark para melhorar uma rule sem “ensinar a prova” ao scanner.

## Ciclo recomendado

1. **Baseline congelada** — rode o corpus antes da alteração.
2. **Diagnóstico** — identifique CWE/casos com FN ou FP.
3. **Causa da rule** — confirme scanner e ruleId no dado mais próximo da origem.
4. **Hipótese de correção** — descreva por que a rule está errando.
5. **Mudança mínima** — altere apenas o necessário.
6. **Development set** — valide a hipótese primeiro.
7. **Regressão completa** — rode os 600 casos.
8. **Holdout** — confirme generalização.
9. **External validation** — para mudanças relevantes, rode OWASP Benchmark/Juliet ou um conjunto independente.
10. **Registro** — salve before/after, commit e rationale.

## Exemplo clássico: command injection

A rule não deve tratar todo `ProcessBuilder` com argumento de usuário como shell injection.

Hard-negative deliberado:

```java
new ProcessBuilder(List.of("printf", "%s", input)).start();
```

Caso vulnerável:

```java
new ProcessBuilder("sh", "-c", "echo " + input).start();
```

A diferença relevante é a interpretação pelo shell, não a mera presença de input.

## Overfitting

Sinais de overfitting:

- rule contém nome/estrutura de `CaseNNNNNN`;
- exceção específica para string usada no benchmark;
- melhora apenas os IDs usados no tuning;
- development melhora e holdout não;
- regra depende de comentários/nome de arquivo;
- safe pair passa a ser silenciado por condição artificial sem valor semântico geral.

## O que registrar para cada mudança

```text
Rule:
CWE:
Problema original:
Casos development usados:
Hipótese:
Mudança:
Before TP/TN/FP/FN:
After TP/TN/FP/FN:
Holdout before/after:
Taxonomy before/after:
Duplicate rate before/after:
External validation:
Risco:
Rollback:
```

## Critério prático

Prefira mudanças que:

- eliminem FN sem abrir uma classe ampla de FP;
- eliminem FP preservando os TPs;
- melhorem contexto/source→sink;
- reconheçam sanitização/allowlist/parametrização real;
- preservem ou melhorem holdout;
- mantenham classificação CWE coerente.

Adicionar mais patterns sem contexto não é automaticamente melhoria de acurácia.
