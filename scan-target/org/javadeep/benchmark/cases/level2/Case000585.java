package org.javadeep.benchmark.cases.level2;

import java.util.regex.Pattern;

public class Case000585 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Pattern pattern = Pattern.compile("^(a+)+$");
        return pattern.matcher(value).matches();
    }
}
