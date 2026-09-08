package io.xguardian.javabench.cases.level1;

import java.util.Map;
import java.util.function.Supplier;

public class Case000502 {
    public Object run(String user) throws Exception {
        String credential = System.getenv("SERVICE_PASSWORD");
        if (credential == null) throw new IllegalStateException("credential unavailable");
        return user + ":" + credential;
    }
}
