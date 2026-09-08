package io.xguardian.javabench.cases.level2;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000145 {
    public Object run(String password, HttpServletResponse response) throws Exception {
        String value = password == null ? "" : password.trim();
        response.sendError(500, "authentication failed; password=" + value);
        return null;
    }
}
