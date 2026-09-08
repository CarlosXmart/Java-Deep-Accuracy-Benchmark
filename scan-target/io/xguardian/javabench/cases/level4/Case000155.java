package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000155 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("password");
        response.sendError(500, String.format("credential rejected: %s", value));
        return null;
    }
}
