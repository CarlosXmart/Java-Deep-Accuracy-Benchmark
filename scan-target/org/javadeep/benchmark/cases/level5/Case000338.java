package org.javadeep.benchmark.cases.level5;

public class Case000338 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        int requested = Integer.parseInt(value);
        int bounded = Math.max(0, Math.min(requested, 1_048_576));
        return new byte[bounded];
    }
}
