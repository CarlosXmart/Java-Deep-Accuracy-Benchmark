package org.javadeep.benchmark.cases.level2;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000047 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String value = input == null ? "" : input.trim();
        response.setContentType("text/html");
        response.getWriter().write(String.format("<p>%s</p>", value));
        return null;
    }
}
