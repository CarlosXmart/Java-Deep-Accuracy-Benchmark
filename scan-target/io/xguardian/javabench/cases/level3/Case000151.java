package io.xguardian.javabench.cases.level3;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000151 {
    public Object run(String password, HttpServletResponse response) throws Exception {
        String value = relay(password);
        response.sendError(500, String.format("credential rejected: %s", value));
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
