package io.xguardian.javabench.cases.level2;

public class Case000327 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        long requested = Long.parseLong(value);
        long sum = 0;
        for (long i = 0; i < requested; i++) sum += i;
        return sum;
    }
}
