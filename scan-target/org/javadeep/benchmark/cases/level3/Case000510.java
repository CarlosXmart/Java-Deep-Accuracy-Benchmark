package org.javadeep.benchmark.cases.level3;

import java.util.Map;
import java.util.function.Supplier;

public class Case000510 {
    public Object run(String user) throws Exception {
        return user + ":" + credential();
    }

    private String credential() {
        String value = System.getenv("SERVICE_PASSWORD");
        if (value == null) throw new IllegalStateException("credential unavailable");
        return value;
    }
}
