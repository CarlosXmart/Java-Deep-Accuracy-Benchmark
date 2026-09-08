package io.xguardian.javabench.cases.level5;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000159 {
    public Object run(HttpServletResponse response, Exception failure) throws Exception {
        response.sendError(500, failure.toString());
        return null;
    }
}
