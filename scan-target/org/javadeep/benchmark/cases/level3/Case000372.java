package org.javadeep.benchmark.cases.level3;

public class Case000372 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        Class<?> type = switch (value) {
            case "string" -> StringBuilder.class;
            case "buffer" -> StringBuffer.class;
            default -> throw new SecurityException("type not allowed");
        };
        return type.getDeclaredConstructor().newInstance();
    }

    private String relay(String value) {
        return value;
    }
}
