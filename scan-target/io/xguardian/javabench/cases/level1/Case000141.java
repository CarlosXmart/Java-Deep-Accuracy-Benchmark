package io.xguardian.javabench.cases.level1;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000141 {
    public Object run(String password, HttpServletResponse response) throws Exception {
        response.sendError(500, "authentication failed; password=" + password);
        return null;
    }
}
