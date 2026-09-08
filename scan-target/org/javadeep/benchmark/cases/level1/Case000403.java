package org.javadeep.benchmark.cases.level1;

import java.util.logging.Logger;

public class Case000403 {
    public Object run(String password, String user) throws Exception {
        Logger logger = Logger.getLogger(Case000403.class.getName());
        logger.info(String.format("credentials %s:%s", user, password));
        return user;
    }
}
