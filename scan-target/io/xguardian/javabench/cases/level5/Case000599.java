package io.xguardian.javabench.cases.level5;

import java.util.regex.Pattern;

public class Case000599 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Pattern pattern = Pattern.compile("^(a|aa)+$");
        return pattern.matcher(value).matches();
    }
}
