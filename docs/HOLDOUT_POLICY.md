# Política de Holdout

## Composição

O corpus v1 contém:

- **450 development**
- **150 holdout**
- holdout = **75 vulneráveis + 75 seguros**
- **30 holdout por nível**
- **5 holdout por CWE**: um por nível

A distribuição é fixa e versionada.

## Objetivo

O development set pode orientar investigação de FPs/FNs. O holdout existe para responder:

> a rule generalizou para casos não usados diretamente durante o ajuste?

## Limitação importante

O repositório é legível para quem tem acesso, então o holdout não é “blind” criptográfico. Trata-se de disciplina de processo.

Para uma avaliação realmente cega:

1. mantenha um segundo repositório privado com ground truth inacessível ao autor da rule; ou
2. gere um release holdout controlado por outra pessoa/time; ou
3. use benchmark externo não consultado durante tuning.

## Proibido

- adicionar exceções por ID;
- consultar implementação do holdout para escrever a rule;
- mudar o ground truth do holdout depois de ver o resultado, sem evidência externa independente;
- reportar apenas development quando holdout regrediu.

## Reporte

Sempre separe:

```text
overall
development
holdout
```

Uma melhoria só no development deve ser classificada como **não generalizada** até investigação.
