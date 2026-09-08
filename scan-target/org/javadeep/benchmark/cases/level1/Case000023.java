package org.javadeep.benchmark.cases.level1;

public class Case000023 {
    public Object run(String input) throws Exception {
        return Runtime.getRuntime().exec(new String[] {"sh", "-c", "echo " + input});
    }
}
