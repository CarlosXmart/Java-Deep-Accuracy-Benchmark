package io.xguardian.javabench.cases.level5;

public class Case000339 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        long requested = Long.parseLong(value);
        long sum = 0;
        for (long i = 0; i < requested; i++) sum += i;
        return sum;
    }
}
