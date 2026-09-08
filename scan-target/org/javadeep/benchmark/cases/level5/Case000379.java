package org.javadeep.benchmark.cases.level5;

public class Case000379 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Class<?> type = Class.forName(value);
        return type.getDeclaredConstructor().newInstance();
    }
}
