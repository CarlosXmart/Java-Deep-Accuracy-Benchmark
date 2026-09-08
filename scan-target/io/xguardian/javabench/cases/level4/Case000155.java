package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000155 {
    public Object run(HttpServletResponse response, Exception failure) throws Exception {
        response.sendError(500, failure.toString());
        return null;
    }
}
