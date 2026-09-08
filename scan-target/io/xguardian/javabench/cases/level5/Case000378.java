package io.xguardian.javabench.cases.level5;

public class Case000378 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Class<?> type = switch (value) {
            case "string" -> StringBuilder.class;
            case "buffer" -> StringBuffer.class;
            default -> throw new SecurityException("type not allowed");
        };
        return type.getDeclaredConstructor().newInstance();
    }
}
