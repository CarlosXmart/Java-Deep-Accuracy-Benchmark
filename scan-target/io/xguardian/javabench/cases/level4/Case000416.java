package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class Case000416 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("password");
        Logger logger = Logger.getLogger(Case000416.class.getName());
        logger.info("authentication event recorded");
        return request.getParameter("user");
    }
}
