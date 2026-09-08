package io.xguardian.javabench.cases.level3;

import java.util.logging.Logger;

public class Case000412 {
    public Object run(String password, String user) throws Exception {
        String value = relay(password);
        Logger logger = Logger.getLogger(Case000412.class.getName());
        logger.info("authentication event recorded");
        return user;
    }

    private String relay(String value) {
        return value;
    }
}
