package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class Case000595 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        Pattern pattern = Pattern.compile("^(a|aa)+$");
        return pattern.matcher(value).matches();
    }
}
