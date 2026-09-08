package io.xguardian.javabench.cases.level1;

import java.util.List;

public class Case000023 {
    public Object run(String input) throws Exception {
        return Runtime.getRuntime().exec("sh -c echo " + input);
    }
}
