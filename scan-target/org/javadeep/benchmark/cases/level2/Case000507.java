package org.javadeep.benchmark.cases.level2;

import java.util.Map;
import java.util.function.Supplier;

public class Case000507 {
    public Object run(String user) throws Exception {
        String configured = "benchmark-only-credential-798";
        String credential = configured;
        return user + ":" + credential;
    }
}
