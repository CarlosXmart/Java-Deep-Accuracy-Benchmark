package org.javadeep.benchmark.cases.level5;

import java.util.List;

public class Case000038 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        return new ProcessBuilder(List.of("printf", "%s", value)).start();
    }
}
