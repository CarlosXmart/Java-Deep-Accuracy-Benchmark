package org.javadeep.benchmark.cases.level3;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000432 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        String value = relay(next);
        String target = BenchSupport.localRedirect(value) ? value : "/app/home";
        response.sendRedirect(target);
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
