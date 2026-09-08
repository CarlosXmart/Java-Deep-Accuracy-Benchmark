# CWE-94 — Code Injection

## Referência autoritativa

- MITRE CWE: https://cwe.mitre.org/data/definitions/94.html
- Nome de referência usado pelo benchmark: **Improper Control of Generation of Code**

> Esta página resume a intenção do teste. A definição normativa e as relações oficiais da fraqueza devem ser consultadas no MITRE CWE.

## O que este benchmark testa

Code injection occurs when externally controlled text is evaluated as executable code.

### Condição positiva

Um caso marcado como vulnerável contém a condição de segurança específica da CWE dentro da região pontuada do arquivo. O ground truth registra arquivo, linhas, dificuldade, conjunto e CWE preferencial.

### Condição negativa / hard-negative

O caso seguro preserva deliberadamente elementos sintáticos parecidos com o caso vulnerável, mas aplica o controle de segurança necessário:

> Do not evaluate untrusted text as code; parse data with a constrained parser.

O objetivo é testar discriminação, não apenas presença de APIs ou palavras-chave.

## Interpretação de erro

- **FN:** o caso vulnerável desta CWE não recebeu finding na região esperada.
- **FP:** o caso seguro desta CWE recebeu finding na região esperada.
- **Erro taxonômico:** a condição foi detectada, porém o CWE retornado diverge do CWE preferencial; isso é medido separadamente de detecção.

## Progressão de dificuldade

1. **Level 1 — direto:** source/sink ou condição insegura no mesmo bloco.
2. **Level 2 — aliases locais:** variáveis intermediárias e pequenas transformações.
3. **Level 3 — interprocedural:** valor atravessa helper/método antes da condição-alvo.
4. **Level 4 — objeto/holder:** passagem por encapsulamento e fronteiras de objeto.
5. **Level 5 — adversarial:** collections/stream/lambda e estrutura deliberadamente mais indireta.

Cada nível contém pares vulnerável/seguro. Levels 3–5 também possuem casos no conjunto holdout.

## Critério de prova

A classificação não é inferida do resultado do XGuardian. Ela é definida antes do scan no `ground-truth/ground_truth.json` e apoiada pela referência oficial acima e pela diferença controlada entre o par vulnerável/seguro.
