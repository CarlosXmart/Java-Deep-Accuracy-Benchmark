package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000035 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        return Runtime.getRuntime().exec(new String[] {"sh", "-c", "echo " + value});
    }
}
