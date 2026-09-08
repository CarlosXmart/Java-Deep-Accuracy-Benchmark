package io.xguardian.javabench.cases.level3;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000149 {
    public Object run(String password, HttpServletResponse response) throws Exception {
        String value = relay(password);
        response.sendError(500, "authentication failed; password=" + value);
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
