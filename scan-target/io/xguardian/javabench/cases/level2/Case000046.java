package io.xguardian.javabench.cases.level2;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000046 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String value = input == null ? "" : input.trim();
        response.setContentType("text/html");
        response.getWriter().write("<div>" + BenchSupport.htmlEscape(value) + "</div>");
        return null;
    }
}
