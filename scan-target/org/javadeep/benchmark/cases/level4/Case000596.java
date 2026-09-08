package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class Case000596 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._-]{1,64}$");
        return pattern.matcher(value).matches();
    }
}
