# Limitações conhecidas

1. Código sintético não reproduz toda a complexidade de aplicações corporativas.
2. O balanceamento 50/50 é útil para métricas, mas não representa a prevalência real de vulnerabilidades.
3. Algumas CWEs de autorização, CSRF e contexto de negócio são difíceis de provar apenas por análise estática.
4. O holdout é transparente e depende de disciplina de processo.
5. Um finding na região pontuada é detection-positive mesmo quando o CWE está incorreto; taxonomia é medida separadamente.
6. Frameworks e versões mudam. O corpus fixa APIs/dependências para reprodutibilidade.
7. Nenhum percentual deste benchmark deve ser comunicado como “acurácia absoluta do XGuardian em Java real”.
