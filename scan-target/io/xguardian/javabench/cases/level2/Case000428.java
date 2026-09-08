package io.xguardian.javabench.cases.level2;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000428 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        String value = next == null ? "" : next.trim();
        String target = BenchSupport.localRedirect(value) ? value : "/app/home";
        response.sendRedirect(target);
        return null;
    }
}
