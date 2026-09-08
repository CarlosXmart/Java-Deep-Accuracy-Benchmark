package io.xguardian.javabench.cases.level5;

import java.util.List;

public class Case000039 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        return Runtime.getRuntime().exec("sh -c echo " + value);
    }
}
