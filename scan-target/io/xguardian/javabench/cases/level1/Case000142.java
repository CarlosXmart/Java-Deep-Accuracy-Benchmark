package io.xguardian.javabench.cases.level1;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000142 {
    public Object run(HttpServletResponse response, Exception failure) throws Exception {
        Logger.getLogger(Case000142.class.getName()).warning("request failed");
        response.sendError(500, "Internal server error");
        return null;
    }
}
