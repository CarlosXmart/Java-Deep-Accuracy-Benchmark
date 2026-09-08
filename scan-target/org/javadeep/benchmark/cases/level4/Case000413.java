package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class Case000413 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("password");
        Logger logger = Logger.getLogger(Case000413.class.getName());
        logger.info("login user=" + request.getParameter("user") + " password=" + value);
        return request.getParameter("user");
    }
}
