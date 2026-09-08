package io.xguardian.javabench.cases.level2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;

public class Case000307 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if ("transfer".equals(action)) {
            response.getWriter().write("state changed");
        }
        return null;
    }
}
