package io.xguardian.javabench.cases.level3;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000150 {
    public Object run(String password, HttpServletResponse response) throws Exception {
        String value = relay(password);
        Logger.getLogger(Case000150.class.getName()).warning("request failed");
        response.sendError(500, "Internal server error");
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
