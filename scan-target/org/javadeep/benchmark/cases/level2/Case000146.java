package org.javadeep.benchmark.cases.level2;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000146 {
    public Object run(String password, HttpServletResponse response) throws Exception {
        String value = password == null ? "" : password.trim();
        Logger.getLogger(Case000146.class.getName()).warning("request failed");
        response.sendError(500, "Internal server error");
        return null;
    }
}
