package io.xguardian.javabench.cases.level5;

import java.util.logging.Logger;

public class Case000418 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000418.class.getName());
        logger.info("login user=" + user);
        return user;
    }
}
