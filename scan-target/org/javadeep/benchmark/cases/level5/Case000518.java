package org.javadeep.benchmark.cases.level5;

import java.util.Map;
import java.util.function.Supplier;

public class Case000518 {
    public Object run(String user) throws Exception {
        Supplier<String> credential = () -> System.getenv("SERVICE_PASSWORD");
        String value = credential.get();
        if (value == null) throw new IllegalStateException("credential unavailable");
        return user + ":" + value;
    }
}
