package io.xguardian.javabench.cases.level4;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Case000435 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("next");
        response.sendRedirect(value);
        return null;
    }
}
