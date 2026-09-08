package org.javadeep.benchmark.cases.level1;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000423 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        response.sendRedirect(next);
        return null;
    }
}
