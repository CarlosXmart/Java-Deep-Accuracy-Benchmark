package io.xguardian.javabench.cases.level5;

import java.util.Map;
import java.util.function.Supplier;

public class Case000519 {
    public Object run(String user) throws Exception {
        Supplier<String> credential = () -> "benchmark-only-credential-798";
        return user + ":" + credential.get();
    }
}
