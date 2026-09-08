package io.xguardian.javabench.cases.level2;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000145 {
    public Object run(HttpServletResponse response, Exception failure) throws Exception {
        response.sendError(500, "operation failed: " + failure.getMessage());
        return null;
    }
}
