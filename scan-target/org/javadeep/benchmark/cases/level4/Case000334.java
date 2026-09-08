package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000334 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        int requested = Integer.parseInt(value);
        int bounded = Math.max(0, Math.min(requested, 1_048_576));
        return new byte[bounded];
    }
}
