package org.javadeep.benchmark.cases.level3;

public class Case000330 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        int requested = Integer.parseInt(value);
        int bounded = Math.max(0, Math.min(requested, 1_048_576));
        return new byte[bounded];
    }

    private String relay(String value) {
        return value;
    }
}
