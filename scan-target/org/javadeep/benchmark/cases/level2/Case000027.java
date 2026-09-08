package org.javadeep.benchmark.cases.level2;

public class Case000027 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        return Runtime.getRuntime().exec(new String[] {"sh", "-c", "echo " + value});
    }
}
