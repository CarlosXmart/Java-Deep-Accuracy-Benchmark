package io.xguardian.javabench.cases.level2;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000048 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String value = input == null ? "" : input.trim();
        response.setContentType("text/plain");
        response.getWriter().write(value == null ? "" : value);
        return null;
    }
}
