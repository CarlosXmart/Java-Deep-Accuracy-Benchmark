package io.xguardian.javabench.cases.level2;

import java.util.logging.Logger;

public class Case000408 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000408.class.getName());
        logger.info("authentication attempt for user=" + user);
        return user;
    }
}
