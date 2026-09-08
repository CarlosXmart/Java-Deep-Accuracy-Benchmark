package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class Case000415 {
    public Object run(String user, String password) throws Exception {
        Logger logger = Logger.getLogger(Case000415.class.getName());
        logger.info(String.format("credentials %s:%s", user, password));
        return user;
    }
}
