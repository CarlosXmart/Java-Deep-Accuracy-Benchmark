package io.xguardian.javabench.cases.level4;

import java.util.Map;
import java.util.function.Supplier;

public class Case000513 {
    public Object run(String user) throws Exception {
        String credential = Map.of("service", "benchmark-only-password-798").get("service");
        return user + ":" + credential;
    }
}
