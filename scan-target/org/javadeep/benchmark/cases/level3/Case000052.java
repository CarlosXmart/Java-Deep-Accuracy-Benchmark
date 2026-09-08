package org.javadeep.benchmark.cases.level3;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000052 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String value = relay(input);
        response.setContentType("text/plain");
        response.getWriter().write(value == null ? "" : value);
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
