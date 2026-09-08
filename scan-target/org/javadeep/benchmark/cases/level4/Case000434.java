package org.javadeep.benchmark.cases.level4;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Case000434 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("next");
        String target = BenchSupport.localRedirect(value) ? value : "/app/home";
        response.sendRedirect(target);
        return null;
    }
}
