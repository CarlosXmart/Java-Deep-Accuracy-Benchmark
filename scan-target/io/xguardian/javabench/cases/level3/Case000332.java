package io.xguardian.javabench.cases.level3;

public class Case000332 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        long requested = Long.parseLong(value);
        long bounded = Math.max(0, Math.min(requested, 100_000));
        long sum = 0;
        for (long i = 0; i < bounded; i++) sum += i;
        return sum;
    }

    private String relay(String value) {
        return value;
    }
}
