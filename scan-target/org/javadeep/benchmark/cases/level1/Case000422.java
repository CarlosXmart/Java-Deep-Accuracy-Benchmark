package org.javadeep.benchmark.cases.level1;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;

public class Case000422 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        String target = BenchSupport.localRedirect(next) ? next : "/app/home";
        response.sendRedirect(target);
        return null;
    }
}
