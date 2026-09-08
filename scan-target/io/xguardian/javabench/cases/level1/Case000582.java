package io.xguardian.javabench.cases.level1;

import java.util.regex.Pattern;

public class Case000582 {
    public Object run(String input) throws Exception {
        Pattern pattern = Pattern.compile("^a+$");
        return pattern.matcher(input).matches();
    }
}
