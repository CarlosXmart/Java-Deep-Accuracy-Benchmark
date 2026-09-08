package io.xguardian.javabench.cases.level1;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000421 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        response.sendRedirect(next);
        return null;
    }
}
