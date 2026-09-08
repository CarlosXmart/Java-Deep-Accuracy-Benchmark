package org.javadeep.benchmark.cases.level2;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000045 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String value = input == null ? "" : input.trim();
        response.setContentType("text/html");
        response.getWriter().write("<div>" + value + "</div>");
        return null;
    }
}
