package org.javadeep.benchmark.cases.level4;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Case000054 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("name");
        response.setContentType("text/html");
        response.getWriter().write("<div>" + BenchSupport.htmlEscape(value) + "</div>");
        return null;
    }
}
