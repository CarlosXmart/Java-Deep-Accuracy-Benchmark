# Controle de mudanças

## Tipos de mudança

### Corpus-semantic
Altera source, safe/vulnerable expectation, CWE, região ou rationale. Invalida comparação direta com baseline anterior do corpus.

### Tooling-only
Altera evaluator/validator sem alterar casos. Pode exigir recalcular scores antigos.

### Documentation-only
Não altera scoring.

## Requisitos para mudança semântica

- justificar em issue/PR;
- apontar referência;
- atualizar par;
- rodar CI;
- registrar impacto no benchmark version;
- evitar alterar resultado esperado em reação ao scanner sem análise independente.

## Versionamento sugerido

- PATCH: docs/tooling sem mudança de semântica de casos;
- MINOR: novos casos/CWEs mantendo filosofia;
- MAJOR: mudança de ground truth/scoring que quebra comparabilidade.

Antes do primeiro baseline oficial, correções de qualidade do corpus v1 podem ser feitas na branch de construção. Depois do freeze, alterações semânticas devem gerar nova versão.
