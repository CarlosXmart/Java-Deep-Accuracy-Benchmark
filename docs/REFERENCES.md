# Referências metodológicas e taxonômicas

Este benchmark é um projeto independente. Os casos Java deste repositório não são cópias dos casos abaixo; as referências orientam metodologia, taxonomia e validação externa.

## OWASP Benchmark for Java

- Projeto oficial: https://owasp.org/www-project-benchmark/
- Repositório de referência: https://github.com/OWASP-Benchmark/BenchmarkJava

Princípios adotados:
- expected results separados do código pontuado;
- combinação de casos vulneráveis e não vulneráveis;
- scorecard baseado em TP, FN, TN e FP;
- casos pequenos e controlados para medir discriminação de ferramentas.

O OWASP descreve o Benchmark Java como um projeto Maven com milhares de casos e um arquivo de expected results associado à versão.

## NIST / NSA Juliet Java

- Dataset Java 1.3: https://samate.nist.gov/SARD/test-suites/111
- Publicação NIST: https://www.nist.gov/publications/juliet-11-cc-and-java-test-suite

A versão Java 1.3 do NIST SARD registra **28.881 casos** organizados em **112 CWEs**. A documentação Juliet descreve a suíte como criada especificamente para testar ferramentas de análise estática e utiliza variações de controle/dataflow e exemplos flawed/non-flawed.

Princípios adotados:
- progressão de dificuldade de fluxo;
- pares positivos/negativos;
- casos sintéticos com condição conhecida;
- cobertura por CWE;
- separação entre geração do caso e avaliação da ferramenta.

## MITRE CWE

- Catálogo oficial: https://cwe.mitre.org/

Cada uma das 30 categorias deste benchmark possui uma página em `docs/cwe/` apontando diretamente para a definição MITRE correspondente.

A taxonomia preferencial de um caso não deve ser alterada apenas para acomodar o output de uma ferramenta. Mudanças de ground truth exigem justificativa técnica independente do scanner.

## Uso responsável das métricas

Resultados neste corpus são evidência de desempenho **neste benchmark**. Eles não equivalem a uma porcentagem universal de acurácia em aplicações Java reais.

A recomendação é combinar:
1. Java Deep Accuracy Benchmark para regressão/tuning fino;
2. OWASP Benchmark para validação externa AppSec;
3. NIST Juliet para cobertura externa ampla;
4. aplicações reais controladas para validação de contexto de produção.
