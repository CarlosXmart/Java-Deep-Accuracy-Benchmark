# Quality Gates

O v1 só pode ser considerado íntegro quando todos estes gates passam.

## Estruturais

- 600 casos;
- 300/300;
- 30 CWEs;
- 20/CWE;
- 10 positivos + 10 negativos/CWE;
- 120/nível;
- 450/150 development/holdout;
- 75/75 no holdout.

## Anti-leakage

Dentro de `scan-target/`:

- nenhum `CWE-123`;
- nenhum marcador TP/TN/FP/FN;
- nenhum VULNERABLE/HARD_NEGATIVE;
- nomes `CaseNNNNNN.java`;
- nenhum padrão de segredo real.

## Reprodutibilidade

```bash
python corpus/generate_cases.py --check
```

deve retornar sem drift.

## Ferramentas

```bash
python -m unittest discover -s tests -p "test_*.py" -v
python tools/validate_ground_truth.py
python tools/validate_cases.py
```

## Java

```bash
mvn -q -f build-harness/pom.xml -DskipTests compile
```

deve compilar todo o payload sem executar os casos.

## CI

O workflow `.github/workflows/benchmark-validation.yml` executa esses gates em push/PR.

## Baseline

Passar CI **não significa** que o XGuardian atingiu determinada acurácia. CI mede integridade do benchmark. Acurácia só existe após scan e evaluator.
