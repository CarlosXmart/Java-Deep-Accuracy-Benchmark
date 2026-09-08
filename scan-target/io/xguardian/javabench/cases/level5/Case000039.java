package io.xguardian.javabench.cases.level5;

import java.util.function.Function;

public class Case000039 {
    public Object run(String input) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(input);
        return Runtime.getRuntime().exec(new String[] {"sh", "-c", "echo " + value});
    }
}
