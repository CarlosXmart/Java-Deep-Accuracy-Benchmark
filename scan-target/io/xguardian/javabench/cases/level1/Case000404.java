package io.xguardian.javabench.cases.level1;

import java.util.logging.Logger;

public class Case000404 {
    public Object run(String password, String user) throws Exception {
        Logger logger = Logger.getLogger(Case000404.class.getName());
        logger.info("authentication event recorded");
        return user;
    }
}
