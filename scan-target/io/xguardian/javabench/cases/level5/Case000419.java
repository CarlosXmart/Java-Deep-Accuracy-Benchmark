package io.xguardian.javabench.cases.level5;

import java.util.logging.Logger;

public class Case000419 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000419.class.getName());
        logger.info(String.format("credentials %s:%s", user, password));
        return user;
    }
}
