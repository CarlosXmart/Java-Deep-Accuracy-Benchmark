package org.javadeep.benchmark.cases.level2;

public class Case000368 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Class<?> type = switch (value) {
            case "string" -> StringBuilder.class;
            case "buffer" -> StringBuffer.class;
            default -> throw new SecurityException("type not allowed");
        };
        return type.getDeclaredConstructor().newInstance();
    }
}
