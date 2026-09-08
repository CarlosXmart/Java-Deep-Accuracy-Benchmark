package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class Case000414 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000414.class.getName());
        logger.info("login user=" + user);
        return user;
    }
}
