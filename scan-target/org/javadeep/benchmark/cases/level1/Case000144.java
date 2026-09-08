package org.javadeep.benchmark.cases.level1;

import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class Case000144 {
    public Object run(String password, HttpServletResponse response) throws Exception {
        Logger.getLogger(Case000144.class.getName()).warning("request failed");
        response.sendError(500, "Request could not be completed");
        return null;
    }
}
