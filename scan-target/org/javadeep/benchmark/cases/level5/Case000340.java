package org.javadeep.benchmark.cases.level5;

public class Case000340 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        long requested = Long.parseLong(value);
        long bounded = Math.max(0, Math.min(requested, 100_000));
        long sum = 0;
        for (long i = 0; i < bounded; i++) sum += i;
        return sum;
    }
}
