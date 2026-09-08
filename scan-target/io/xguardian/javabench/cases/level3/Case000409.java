package io.xguardian.javabench.cases.level3;

import java.util.logging.Logger;

public class Case000409 {
    public Object run(String password, String user) throws Exception {
        String value = relay(password);
        Logger logger = Logger.getLogger(Case000409.class.getName());
        logger.info("login user=" + user + " password=" + value);
        return user;
    }

    private String relay(String value) {
        return value;
    }
}
