package io.xguardian.javabench.cases.level2;

public class Case000365 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Class<?> type = Class.forName(value);
        return type.getDeclaredConstructor().newInstance();
    }
}
