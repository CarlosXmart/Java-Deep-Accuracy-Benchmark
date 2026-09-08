package org.javadeep.benchmark.cases.level1;

import java.util.regex.Pattern;

public class Case000584 {
    public Object run(String input) throws Exception {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._-]{1,64}$");
        return pattern.matcher(input).matches();
    }
}
