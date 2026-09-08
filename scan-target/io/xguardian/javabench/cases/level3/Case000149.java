package io.xguardian.javabench.cases.level3;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000149 {
    public Object run(HttpServletResponse response, Exception failure) throws Exception {
        response.sendError(500, "operation failed: " + failure.getMessage());
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
