package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000333 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        int requested = Integer.parseInt(value);
        return new byte[requested];
    }
}
