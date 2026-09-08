package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class Case000594 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        Pattern pattern = Pattern.compile("^a+$");
        return pattern.matcher(value).matches();
    }
}
