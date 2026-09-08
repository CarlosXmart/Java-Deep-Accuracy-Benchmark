# Limitações conhecidas

## 1. Corpus sintético

Os casos são menores e mais isolados que sistemas corporativos.

## 2. Prevalência artificial

50% vulnerável / 50% seguro é útil para calibração, não representa distribuição de produção.

## 3. Framework coverage

Jakarta Servlet e APIs JDK aparecem em múltiplos casos, mas o v1 não pretende cobrir exaustivamente Spring, Hibernate, Micronaut, Quarkus, Struts, Android e todo o ecossistema.

## 4. Dependências

O payload evita dependências pesadas para manter reprodutibilidade. Isso reduz certos dataflows reais de bibliotecas.

## 5. Holdout observável

O holdout é processual, não secreto.

## 6. Safe é CWE-específico

Um hard-negative é considerado seguro **para a condição pontuada**. Isso não certifica o arquivo em todas as dimensões de segurança.

## 7. Matching por linha

O evaluator usa região + tolerância. Scanners que apontam locations muito distantes podem exigir análise manual de extraneous findings.

## 8. Scanner attribution

Se o resultado final do target SAST scanner não preservar scanner/ruleId, o benchmark mede o pipeline agregado, mas não consegue atribuir cada FP/FN à rule originadora.

## 9. Runtime exploitability

O projeto não executa vulnerabilidades como prova dinâmica. A verdade é definida por revisão estática e referência de fraqueza.

## 10. Resultado não é certificação

Um score alto neste corpus não prova ausência de vulnerabilidades em software real.
