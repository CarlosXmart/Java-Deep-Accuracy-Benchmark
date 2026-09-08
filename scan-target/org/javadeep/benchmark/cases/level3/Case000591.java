package org.javadeep.benchmark.cases.level3;

import java.util.regex.Pattern;

public class Case000591 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        Pattern pattern = Pattern.compile("^(a|aa)+$");
        return pattern.matcher(value).matches();
    }

    private String relay(String value) {
        return value;
    }
}
