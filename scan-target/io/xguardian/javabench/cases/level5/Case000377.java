package io.xguardian.javabench.cases.level5;

public class Case000377 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Class<?> type = Class.forName(value);
        return type.getDeclaredConstructor().newInstance();
    }
}
