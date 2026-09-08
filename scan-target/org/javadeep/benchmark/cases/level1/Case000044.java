package org.javadeep.benchmark.cases.level1;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000044 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        response.setContentType("text/plain");
        response.getWriter().write(input == null ? "" : input);
        return null;
    }
}
