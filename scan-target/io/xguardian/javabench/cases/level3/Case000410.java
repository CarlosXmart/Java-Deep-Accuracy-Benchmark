package io.xguardian.javabench.cases.level3;

import java.util.logging.Logger;

public class Case000410 {
    public Object run(String password, String user) throws Exception {
        String value = relay(password);
        Logger logger = Logger.getLogger(Case000410.class.getName());
        logger.info("login user=" + user);
        return user;
    }

    private String relay(String value) {
        return value;
    }
}
