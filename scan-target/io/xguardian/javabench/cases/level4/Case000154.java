package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000154 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("password");
        Logger.getLogger(Case000154.class.getName()).warning("request failed");
        response.sendError(500, "Internal server error");
        return null;
    }
}
