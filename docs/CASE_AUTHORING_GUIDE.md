# Guia para criação e revisão de casos

## Checklist de novo caso

- [ ] nome neutro;
- [ ] sem CWE/TP/TN/FP/FN no payload;
- [ ] Java 17 compilável;
- [ ] uma condição primária de segurança;
- [ ] source/configuração clara;
- [ ] sink/efeito claro;
- [ ] par positivo/negativo quando aplicável;
- [ ] target region mínima;
- [ ] rationale independente;
- [ ] MITRE CWE oficial;
- [ ] difficulty coerente com o código;
- [ ] cohort definido antes de ver resultado;
- [ ] nenhum segredo real.

## Princípio de isolamento

Evite que o caso seja simultaneamente um teste plausível de duas fraquezas independentes na mesma região. Quando isso for inevitável, documente e considere `accepted_cwes` apenas se semanticamente defensável.

## Hard-negative bom

Um hard-negative deve parecer vulnerável para uma rule superficial, mas possuir controle real.

Exemplos:

- SQL concatenado? Não: use PreparedStatement.
- Path? Normalize + containment.
- OS process? programa fixo/argv sem shell.
- SSRF? scheme/host/port allowlist.
- XML? DTD/entities/external access desabilitados.
- Deserialization? evitar ou restringir classes estritamente.
- Cookie? atributo de segurança explicitamente configurado.

## Revisão por dificuldade

Level 5 não pode ser apenas Level 1 com uma linha irrelevante. A indirection precisa participar da condição que o scanner precisa compreender.

## Execução

Fixtures vulneráveis são para análise estática. O build harness apenas compila.
