package org.javadeep.benchmark.cases.level3;

import java.util.List;

public class Case000032 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        if (value == null || !value.matches("[A-Za-z0-9._-]{1,32}")) throw new SecurityException("invalid argument");
        return new ProcessBuilder("/usr/bin/printf", "%s", value).start();
    }

    private String relay(String value) {
        return value;
    }
}
