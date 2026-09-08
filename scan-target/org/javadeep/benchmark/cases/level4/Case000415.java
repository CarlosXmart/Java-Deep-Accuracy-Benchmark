package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class Case000415 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("password");
        Logger logger = Logger.getLogger(Case000415.class.getName());
        logger.info(String.format("credentials %s:%s", request.getParameter("user"), value));
        return request.getParameter("user");
    }
}
