package io.xguardian.javabench.cases.level1;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000043 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        response.getWriter().write(String.format("<p>%s</p>", input));
        return null;
    }
}
