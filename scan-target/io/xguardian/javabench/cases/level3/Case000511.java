package io.xguardian.javabench.cases.level3;

import java.util.Map;
import java.util.function.Supplier;

public class Case000511 {
    public Object run(String user) throws Exception {
        return user + ":" + credential();
    }

    private String credential() { return "benchmark-only-credential-798"; }
}
