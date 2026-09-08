package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000336 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        long requested = Long.parseLong(value);
        long bounded = Math.max(0, Math.min(requested, 100_000));
        long sum = 0;
        for (long i = 0; i < bounded; i++) sum += i;
        return sum;
    }
}
