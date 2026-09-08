package io.xguardian.javabench.cases.level3;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000431 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        String value = relay(next);
        response.sendRedirect(value);
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
