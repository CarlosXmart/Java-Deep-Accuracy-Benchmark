package io.xguardian.javabench.cases.level3;

import java.util.logging.Logger;

public class Case000412 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000412.class.getName());
        logger.info("authentication attempt for user=" + user);
        return user;
    }

    private String relay(String value) {
        return value;
    }
}
