package org.javadeep.benchmark.cases.level2;

public class Case000325 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        int requested = Integer.parseInt(value);
        return new byte[requested];
    }
}
