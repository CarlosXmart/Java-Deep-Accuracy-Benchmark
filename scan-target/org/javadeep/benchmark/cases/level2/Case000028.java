package org.javadeep.benchmark.cases.level2;

import java.util.List;

public class Case000028 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        if (value == null || !value.matches("[A-Za-z0-9._-]{1,32}")) throw new SecurityException("invalid argument");
        return new ProcessBuilder("/usr/bin/printf", "%s", value).start();
    }
}
