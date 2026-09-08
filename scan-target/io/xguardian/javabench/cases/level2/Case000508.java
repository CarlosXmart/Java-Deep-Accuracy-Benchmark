package io.xguardian.javabench.cases.level2;

import java.util.Map;
import java.util.function.Supplier;

public class Case000508 {
    public Object run(String user) throws Exception {
        String configured = System.getenv("SERVICE_PASSWORD");
        String credential = configured;
        if (credential == null) throw new IllegalStateException("credential unavailable");
        return user + ":" + credential;
    }
}
