package org.javadeep.benchmark.cases.level1;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000042 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        response.getWriter().write("<div>" + BenchSupport.htmlEscape(input) + "</div>");
        return null;
    }
}
