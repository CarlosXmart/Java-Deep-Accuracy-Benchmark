package org.javadeep.benchmark.cases.level3;

import java.util.Map;
import java.util.function.Supplier;

public class Case000509 {
    public Object run(String user) throws Exception {
        return user + ":" + credential();
    }

    private String credential() { return "benchmark-only-password-798"; }
}
