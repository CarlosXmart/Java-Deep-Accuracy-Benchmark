package org.javadeep.benchmark.cases.level5;

import java.util.regex.Pattern;

public class Case000600 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._-]{1,64}$");
        return pattern.matcher(value).matches();
    }
}
