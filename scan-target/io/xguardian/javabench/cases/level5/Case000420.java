package io.xguardian.javabench.cases.level5;

import java.util.logging.Logger;

public class Case000420 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000420.class.getName());
        logger.info("authentication attempt for user=" + user);
        return user;
    }
}
