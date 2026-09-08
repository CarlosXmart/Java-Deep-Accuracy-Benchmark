# Metodologia

## Objetivo

Medir de forma reproduzível a capacidade do SAST de distinguir vulnerabilidades Java reais, dentro de condições controladas, de construções seguras propositalmente semelhantes.

## Desenho do corpus

- 30 CWEs.
- 20 casos por CWE.
- 10 positivos e 10 negativos por CWE.
- 5 níveis de dificuldade.
- 600 casos pontuados no total.
- 420 casos de calibração.
- 180 casos de holdout.

Cada CWE possui exatamente quatro casos em cada nível: dois vulneráveis e dois seguros. Nos Levels 1 e 2, os quatro pertencem à calibração. Nos Levels 3, 4 e 5, um par pertence à calibração e outro ao holdout.

## Princípios inspiradores

### OWASP Benchmark for Java

O OWASP Benchmark publica expected results para os casos e usa verdade conhecida para calcular scorecards de ferramentas. O projeto também combina casos vulneráveis e não vulneráveis. Referência: https://owasp.org/www-project-benchmark/

### NIST/NSA Juliet

A documentação do Juliet descreve casos criados especificamente para testar ferramentas de análise estática, com falhas conhecidas e variantes de controle/dataflow. A versão Java 1.3 do NIST SARD possui 28.881 casos organizados em 112 CWEs. Referências:

- https://samate.nist.gov/SARD/test-suites/111
- https://www.nist.gov/publications/juliet-11-cc-and-java-test-suite

### MITRE CWE

A taxonomia preferencial de cada caso é vinculada a uma página oficial do MITRE CWE. As páginas deste repositório são explicativas; o MITRE é a referência taxonômica.

## Unidade de pontuação

A unidade primária é o **caso**, não a quantidade bruta de findings.

Um arquivo contém uma condição de segurança pontuada. Findings redundantes na mesma região não criam TPs adicionais.

## Região pontuada

Os arquivos possuem marcadores neutros `region:start` e `region:end`. Eles são idênticos em positivos e negativos e não informam a expectativa.

O ground truth registra as linhas internas a essa região.

## Detecção x taxonomia

A avaliação separa:

- **Detection:** houve finding na região-alvo?
- **Taxonomy exact:** o CWE retornado é o CWE preferencial?
- **Taxonomy accepted:** o CWE retornado pertence ao conjunto explicitamente aceito pelo caso?

Isso evita transformar um erro de taxonomia em falso negativo de detecção.

## Hard-negatives

Negativos não são arquivos vazios ou códigos obviamente seguros. Eles preservam APIs, estruturas e fluxos parecidos com o caso vulnerável, mas adicionam a condição de segurança relevante. São essenciais para medir FP.

## Prevenção de overfitting

- Calibration pode orientar ajuste de rules.
- Holdout não deve orientar implementação.
- Mudanças devem ser avaliadas em ambos.
- Validação externa com OWASP Benchmark e Juliet é recomendada antes de generalizar conclusões.
