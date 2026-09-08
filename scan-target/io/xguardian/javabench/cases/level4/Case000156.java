package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000156 {
    public Object run(HttpServletResponse response, Exception failure) throws Exception {
        Logger.getLogger(Case000156.class.getName()).warning("request failed");
        response.sendError(500, "Request could not be completed");
        return null;
    }
}
