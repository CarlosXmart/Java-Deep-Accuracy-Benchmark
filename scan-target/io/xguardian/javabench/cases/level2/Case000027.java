package io.xguardian.javabench.cases.level2;

import java.util.List;

public class Case000027 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        return Runtime.getRuntime().exec("sh -c echo " + value);
    }
}
