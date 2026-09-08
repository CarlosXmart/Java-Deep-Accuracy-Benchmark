package io.xguardian.javabench.cases.level5;

import java.util.List;

public class Case000037 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        return new ProcessBuilder("sh", "-c", "printf %s " + value).start();
    }
}
