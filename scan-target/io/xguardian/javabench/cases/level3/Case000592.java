package io.xguardian.javabench.cases.level3;

import java.util.regex.Pattern;

public class Case000592 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._-]{1,64}$");
        return pattern.matcher(value).matches();
    }

    private String relay(String value) {
        return value;
    }
}
