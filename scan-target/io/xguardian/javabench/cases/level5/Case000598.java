package io.xguardian.javabench.cases.level5;

import java.util.regex.Pattern;

public class Case000598 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Pattern pattern = Pattern.compile("^a+$");
        return pattern.matcher(value).matches();
    }
}
