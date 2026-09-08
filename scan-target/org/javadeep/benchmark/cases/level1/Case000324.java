package org.javadeep.benchmark.cases.level1;

public class Case000324 {
    public Object run(String input) throws Exception {
        long requested = Long.parseLong(input);
        long bounded = Math.max(0, Math.min(requested, 100_000));
        long sum = 0;
        for (long i = 0; i < bounded; i++) sum += i;
        return sum;
    }
}
