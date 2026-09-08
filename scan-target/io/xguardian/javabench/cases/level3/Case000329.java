package io.xguardian.javabench.cases.level3;

public class Case000329 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        int requested = Integer.parseInt(value);
        return new byte[requested];
    }

    private String relay(String value) {
        return value;
    }
}
