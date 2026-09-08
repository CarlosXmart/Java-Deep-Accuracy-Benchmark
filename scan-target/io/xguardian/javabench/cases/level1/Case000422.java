package io.xguardian.javabench.cases.level1;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000422 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        String target = BenchSupport.localRedirect(next) ? next : "/app/home";
        response.sendRedirect(target);
        return null;
    }
}
