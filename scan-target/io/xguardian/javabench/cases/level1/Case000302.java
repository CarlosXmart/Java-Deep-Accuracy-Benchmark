package io.xguardian.javabench.cases.level1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;

public class Case000302 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String supplied = request.getParameter("csrf");
        Object expected = request.getSession(false) == null ? null : request.getSession(false).getAttribute("csrf");
        if (expected == null || !Objects.equals(expected.toString(), supplied)) {
            response.sendError(403, "forbidden");
            return null;
        }
        response.getWriter().write("state changed");
        return null;
    }
}
