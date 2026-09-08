package io.xguardian.javabench.cases.level3;

import java.util.regex.Pattern;

public class Case000590 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        Pattern pattern = Pattern.compile("^a+$");
        return pattern.matcher(value).matches();
    }

    private String relay(String value) {
        return value;
    }
}
