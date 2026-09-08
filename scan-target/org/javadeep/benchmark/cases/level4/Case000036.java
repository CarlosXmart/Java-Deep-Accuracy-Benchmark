package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class Case000036 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        if (value == null || !value.matches("[A-Za-z0-9._-]{1,32}")) throw new SecurityException("invalid argument");
        return new ProcessBuilder("/usr/bin/printf", "%s", value).start();
    }
}
