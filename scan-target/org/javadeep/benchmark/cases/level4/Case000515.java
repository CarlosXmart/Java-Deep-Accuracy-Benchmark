package org.javadeep.benchmark.cases.level4;

import java.util.Map;
import java.util.function.Supplier;

public class Case000515 {
    public Object run(String user) throws Exception {
        String credential = Map.of("service", "benchmark-only-credential-798").get("service");
        return user + ":" + credential;
    }
}
