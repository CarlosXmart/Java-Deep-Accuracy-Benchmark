package io.xguardian.javabench.cases.level3;

import java.util.List;

public class Case000030 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return new ProcessBuilder(List.of("printf", "%s", value)).start();
    }

    private String relay(String value) {
        return value;
    }
}
