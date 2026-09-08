package org.javadeep.benchmark.cases.level2;

public class Case000326 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        int requested = Integer.parseInt(value);
        int bounded = Math.max(0, Math.min(requested, 1_048_576));
        return new byte[bounded];
    }
}
