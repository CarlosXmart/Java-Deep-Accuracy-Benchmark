package io.xguardian.javabench.cases.level5;

import java.util.List;

public class Case000040 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        if (value == null || !value.matches("[A-Za-z0-9._-]{1,32}")) throw new SecurityException("invalid argument");
        return new ProcessBuilder("/usr/bin/printf", "%s", value).start();
    }
}
