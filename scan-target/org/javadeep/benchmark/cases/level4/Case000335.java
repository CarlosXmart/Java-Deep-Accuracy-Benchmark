package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000335 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        long requested = Long.parseLong(value);
        long sum = 0;
        for (long i = 0; i < requested; i++) sum += i;
        return sum;
    }
}
