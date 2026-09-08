package io.xguardian.javabench.cases.level5;

public class Case000337 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        int requested = Integer.parseInt(value);
        return new byte[requested];
    }
}
