package io.xguardian.javabench.cases.level2;

import java.util.regex.Pattern;

public class Case000587 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Pattern pattern = Pattern.compile("^(a|aa)+$");
        return pattern.matcher(value).matches();
    }
}
