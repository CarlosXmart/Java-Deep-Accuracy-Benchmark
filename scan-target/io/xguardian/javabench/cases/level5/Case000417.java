package io.xguardian.javabench.cases.level5;

import java.util.logging.Logger;

public class Case000417 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000417.class.getName());
        logger.info("login user=" + user + " password=" + password);
        return user;
    }
}
