package org.javadeep.benchmark.cases.level2;

public class Case000367 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Class<?> type = Class.forName(value);
        return type.getDeclaredConstructor().newInstance();
    }
}
