package org.javadeep.benchmark.cases.level3;

import java.util.logging.Logger;

public class Case000411 {
    public Object run(String password, String user) throws Exception {
        String value = relay(password);
        Logger logger = Logger.getLogger(Case000411.class.getName());
        logger.info(String.format("credentials %s:%s", user, value));
        return user;
    }

    private String relay(String value) {
        return value;
    }
}
