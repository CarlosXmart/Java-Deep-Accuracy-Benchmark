package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class Case000416 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000416.class.getName());
        logger.info("authentication attempt for user=" + user);
        return user;
    }
}
