package io.xguardian.javabench.cases.level2;

import java.util.Map;
import java.util.function.Supplier;

public class Case000505 {
    public Object run(String user) throws Exception {
        String configured = "benchmark-only-password-798";
        String credential = configured;
        return user + ":" + credential;
    }
}
