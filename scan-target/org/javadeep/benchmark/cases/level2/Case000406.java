package org.javadeep.benchmark.cases.level2;

import java.util.logging.Logger;

public class Case000406 {
    public Object run(String password, String user) throws Exception {
        String value = password == null ? "" : password.trim();
        Logger logger = Logger.getLogger(Case000406.class.getName());
        logger.info("authentication event recorded");
        return user;
    }
}
