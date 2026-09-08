package org.javadeep.benchmark.cases.level3;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000429 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        String value = relay(next);
        response.sendRedirect(value);
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
