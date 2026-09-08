package org.javadeep.benchmark.cases.level1;

import java.util.Map;
import java.util.function.Supplier;

public class Case000503 {
    public Object run(String user) throws Exception {
        String credential = "benchmark-only-credential-798";
        return user + ":" + credential;
    }
}
