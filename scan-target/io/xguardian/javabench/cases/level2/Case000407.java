package io.xguardian.javabench.cases.level2;

import java.util.logging.Logger;

public class Case000407 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000407.class.getName());
        logger.info(String.format("credentials %s:%s", user, password));
        return user;
    }
}
