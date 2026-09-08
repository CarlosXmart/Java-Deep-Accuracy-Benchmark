package io.xguardian.javabench.cases.level1;

import java.util.List;

public class Case000024 {
    public Object run(String input) throws Exception {
        if (input == null || !input.matches("[A-Za-z0-9._-]{1,32}")) throw new SecurityException("invalid argument");
        return new ProcessBuilder("/usr/bin/printf", "%s", input).start();
    }
}
