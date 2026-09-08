package org.javadeep.benchmark.cases.level1;

public class Case000323 {
    public Object run(String input) throws Exception {
        long requested = Long.parseLong(input);
        long sum = 0;
        for (long i = 0; i < requested; i++) sum += i;
        return sum;
    }
}
