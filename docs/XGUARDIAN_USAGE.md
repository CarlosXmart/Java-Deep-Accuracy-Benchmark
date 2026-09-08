# Uso com XGuardian

## Regra crítica

### Score oficial

Escaneie **somente**:

```text
scan-target/
```

Não use `.`.

### Tuning rápido

Durante desenvolvimento de rules, é aceitável escanear somente:

```text
scan-target/io/xguardian/javabench/cases/calibration/
```

O score de release, entretanto, deve ser produzido sobre `scan-target/`.

## GitHub Action oficial

O workflow deste repositório usa a Action SAST oficial do XGuardian fixada no commit da release v26.6.2:

```text
xguardian-actions/actions/sast@6373d9375d3a859f602dcf53b37a3d8326c8a248
```

Referência da Action: https://github.com/xguardian-actions/actions/tree/v26.6.2/sast

A configuração esperada é:

- Secret: `XGUARDIAN_TOKEN`
- Variable: `XGUARDIAN_APP_ID`
- `scan_directory: scan-target`
- `get_scan_id: true`

O workflow não cria aplicação automaticamente; usa `app_id` dedicado para evitar que metadata de linguagem influencie a preparação do benchmark.

## Export de resultado

Após o scan, exporte JSON do SAST para `results/xguardian.json` e execute o evaluator.

Nunca faça commit de token, credencial ou segredo.
