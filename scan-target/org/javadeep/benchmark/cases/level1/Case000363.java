package org.javadeep.benchmark.cases.level1;

public class Case000363 {
    public Object run(String input) throws Exception {
        Class<?> type = Class.forName(input);
        return type.getDeclaredConstructor().newInstance();
    }
}
