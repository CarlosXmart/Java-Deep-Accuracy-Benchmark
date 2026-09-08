# Política de holdout

O holdout contém 180 casos, 30% do corpus.

## Finalidade

Ele existe para responder:

> A rule generaliza para variações que não foram usadas diretamente durante o tuning?

## Regras de governança

- Não use o conteúdo do holdout para implementar exceções específicas.
- Não altere um caso holdout porque a rule falhou sem primeiro revisar a validade do ground truth.
- Qualquer mudança de ground truth deve ser documentada e revisada separadamente da mudança de rule.
- Durante tuning diário, prefira o calibration set.
- Antes de merge/release da rule, rode `scan-target/` completo.

O holdout é visível no repositório por transparência e auditabilidade; portanto é um holdout de processo, não um conjunto criptograficamente secreto.
