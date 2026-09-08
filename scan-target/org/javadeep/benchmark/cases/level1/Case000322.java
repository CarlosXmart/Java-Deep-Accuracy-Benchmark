package org.javadeep.benchmark.cases.level1;

public class Case000322 {
    public Object run(String input) throws Exception {
        int requested = Integer.parseInt(input);
        int bounded = Math.max(0, Math.min(requested, 1_048_576));
        return new byte[bounded];
    }
}
