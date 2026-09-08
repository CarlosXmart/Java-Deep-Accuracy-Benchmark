package io.xguardian.javabench.cases.level5;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Case000058 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("name");
        response.setContentType("text/html");
        response.getWriter().write("<div>" + BenchSupport.htmlEscape(value) + "</div>");
        return null;
    }
}
