package org.javadeep.benchmark.cases.level2;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000427 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        String value = next == null ? "" : next.trim();
        response.sendRedirect(value);
        return null;
    }
}
