package io.xguardian.javabench.cases.level2;

import java.util.logging.Logger;

public class Case000405 {
    public Object run(String password, String user) throws Exception {
        String value = password == null ? "" : password.trim();
        Logger logger = Logger.getLogger(Case000405.class.getName());
        logger.info("login user=" + user + " password=" + value);
        return user;
    }
}
