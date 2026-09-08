package org.javadeep.benchmark.cases.level3;

import java.util.List;

public class Case000029 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return new ProcessBuilder("sh", "-c", "printf %s " + value).start();
    }

    private String relay(String value) {
        return value;
    }
}
