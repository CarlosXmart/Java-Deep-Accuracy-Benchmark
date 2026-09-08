package io.xguardian.javabench.cases.level3;

import java.util.List;

public class Case000031 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return Runtime.getRuntime().exec("sh -c echo " + value);
    }

    private String relay(String value) {
        return value;
    }
}
