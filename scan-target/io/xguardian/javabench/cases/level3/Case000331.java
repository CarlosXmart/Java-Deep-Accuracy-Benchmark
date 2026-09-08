package io.xguardian.javabench.cases.level3;

public class Case000331 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        long requested = Long.parseLong(value);
        long sum = 0;
        for (long i = 0; i < requested; i++) sum += i;
        return sum;
    }

    private String relay(String value) {
        return value;
    }
}
