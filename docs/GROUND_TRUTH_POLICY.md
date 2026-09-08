# Política de Ground Truth

## Fonte primária

A semântica de cada fraqueza deve ser sustentada pelo **MITRE CWE** correspondente.

```text
https://cwe.mitre.org/data/definitions/<ID>.html
```

CodeQL, SonarSource, OWASP e NIST podem apoiar a interpretação, mas não substituem a definição da CWE.

## Regra para marcar vulnerável

Um caso só pode ser `expected_vulnerable=true` quando:

1. há comportamento que satisfaz a fraqueza testada;
2. o source/configuração e sink/efeito estão identificáveis;
3. o controle ausente é documentado;
4. a rationale explica a decisão sem depender do resultado do target SAST scanner.

## Regra para hard-negative

Um caso seguro deve conter um controle que neutraliza especificamente a condição testada.

“Seguro” significa **seguro para a CWE pontuada**, não “software universalmente seguro”.

Exemplo: um upload com allowlist de extensões pode ser hard-negative para a condição estreita de tipo executável testada, mas isso não certifica tamanho, malware scanning, armazenamento ou autorização.

## Alterações de ground truth

Mudanças exigem:

- referência oficial;
- rationale;
- revisão do par positivo/negativo;
- atualização de target region se necessário;
- execução de validators;
- registro em commit.

O ground truth nunca deve ser alterado apenas porque um scanner discordou.

## Taxonomia

`preferred_cwe` é a classificação principal.

`accepted_cwes` só deve conter alternativas quando houver justificativa semântica documentada. Não alargue essa lista para melhorar artificialmente taxonomy accuracy.
