package io.xguardian.javabench.cases.level1;

public class Case000362 {
    public Object run(String input) throws Exception {
        Class<?> type = switch (input) {
            case "string" -> StringBuilder.class;
            case "buffer" -> StringBuffer.class;
            default -> throw new SecurityException("type not allowed");
        };
        return type.getDeclaredConstructor().newInstance();
    }
}
