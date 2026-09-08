package io.xguardian.javabench.cases.level5;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000158 {
    public Object run(HttpServletResponse response, Exception failure) throws Exception {
        Logger.getLogger(Case000158.class.getName()).warning("request failed");
        response.sendError(500, "Internal server error");
        return null;
    }
}
