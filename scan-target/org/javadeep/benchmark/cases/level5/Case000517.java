package org.javadeep.benchmark.cases.level5;

import java.util.Map;
import java.util.function.Supplier;

public class Case000517 {
    public Object run(String user) throws Exception {
        Supplier<String> credential = () -> "benchmark-only-password-798";
        return user + ":" + credential.get();
    }
}
