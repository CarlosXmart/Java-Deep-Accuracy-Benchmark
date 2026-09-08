package org.javadeep.benchmark.cases.level2;

public class Case000328 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        long requested = Long.parseLong(value);
        long bounded = Math.max(0, Math.min(requested, 100_000));
        long sum = 0;
        for (long i = 0; i < bounded; i++) sum += i;
        return sum;
    }
}
