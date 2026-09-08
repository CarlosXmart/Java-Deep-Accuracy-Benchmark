package io.xguardian.javabench.cases.level2;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Case000426 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String next = request.getParameter("next");
        if (!BenchSupport.localRedirect(next)) next = "/app/home";
        response.sendRedirect(next);
        return null;
    }
}
