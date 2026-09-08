package org.javadeep.benchmark.cases.level1;

import java.util.logging.Logger;

public class Case000402 {
    public Object run(String password, String user) throws Exception {
        Logger logger = Logger.getLogger(Case000402.class.getName());
        logger.info("authentication event recorded");
        return user;
    }
}
