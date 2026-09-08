package io.xguardian.javabench.cases.level4;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Case000053 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = relay(request.getParameter("name"));
        response.setContentType("text/html");
        response.getWriter().write("<div>" + value + "</div>");
        return null;
    }

    private String relay(String value) { return value; }
}
