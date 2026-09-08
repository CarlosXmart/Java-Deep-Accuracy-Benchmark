# Reprodutibilidade

## Fonte canônica

`corpus/definitions.json` contém a definição materializada e determinística dos 600 casos.

`corpus/generate_cases.py` reconstrói:

- 600 `.java`;
- `ground-truth/ground_truth.json`;
- `ground-truth/expected_counts.json`;
- `ground-truth/expected_results.csv`.

## Verificação

```bash
python corpus/generate_cases.py --check
```

Qualquer drift byte-a-byte em artefato gerado falha.

## Ambiente de compilação

- Java 17
- Maven
- Jakarta Servlet API como dependência `provided`

```bash
mvn -q -f build-harness/pom.xml -DskipTests compile
```

O build não chama os métodos vulneráveis.

## Freeze

Para um resultado benchmarkável, registre o SHA Git do corpus. Não compare scans feitos sobre SHAs diferentes como se fossem before/after da mesma rule.
