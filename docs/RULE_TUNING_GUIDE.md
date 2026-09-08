# Guia de refinamento de rules

## Ciclo recomendado

1. Salve o resultado antes da mudança.
2. Altere uma família pequena de rules.
3. Rode validação local do benchmark.
4. Escaneie calibration.
5. Compare before/after.
6. Se não houver regressão, execute full scan com holdout.
7. Só então considere promover a rule.

## Não otimize para um arquivo

Se uma rule é alterada especificamente para fazer `Case000123.java` passar, existe risco de overfitting.

A regra deve representar a **condição de segurança da CWE**, e não a forma literal do caso.

## Exemplo: command injection

Uma rule não deve marcar qualquer `ProcessBuilder` com dado externo. Ela precisa distinguir, quando tecnicamente possível, entre:

- shell recebendo string interpretável;
- executável fixo recebendo o dado como argumento separado.

É justamente esse tipo de distinção que os hard-negatives testam.

## Sinais de regressão

- recall sobe e FPR sobe muito;
- finding muda de CWE sem ganho de detecção;
- um caso direto melhora, mas levels 4–5 pioram;
- regra passa calibration e falha no holdout.

## Registro

Guarde cada execução relevante em:

```text
results/<data-ou-commit>/
```

O diretório é ignorado no Git por padrão.
