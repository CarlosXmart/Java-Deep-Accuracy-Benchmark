package org.javadeep.benchmark.cases.level4;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Case000056 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("message");
        response.setContentType("text/plain");
        response.getWriter().write(value == null ? "" : value);
        return null;
    }
}
