package org.javadeep.benchmark.cases.level1;

import java.util.List;

public class Case000022 {
    public Object run(String input) throws Exception {
        return new ProcessBuilder(List.of("printf", "%s", input)).start();
    }
}
