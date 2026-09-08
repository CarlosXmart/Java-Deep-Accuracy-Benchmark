package io.xguardian.javabench.cases.level3;

public class Case000369 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        Class<?> type = Class.forName(value);
        return type.getDeclaredConstructor().newInstance();
    }

    private String relay(String value) {
        return value;
    }
}
