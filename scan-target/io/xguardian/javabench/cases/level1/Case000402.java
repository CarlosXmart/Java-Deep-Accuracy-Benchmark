package io.xguardian.javabench.cases.level1;

import java.util.logging.Logger;

public class Case000402 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000402.class.getName());
        logger.info("login user=" + user);
        return user;
    }
}
