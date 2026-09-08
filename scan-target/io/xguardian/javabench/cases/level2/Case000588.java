package io.xguardian.javabench.cases.level2;

import java.util.regex.Pattern;

public class Case000588 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._-]{1,64}$");
        return pattern.matcher(value).matches();
    }
}
