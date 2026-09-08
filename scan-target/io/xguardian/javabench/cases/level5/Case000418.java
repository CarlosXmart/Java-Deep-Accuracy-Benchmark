package io.xguardian.javabench.cases.level5;

import java.util.function.Function;
import java.util.logging.Logger;

public class Case000418 {
    public Object run(String password, String user) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(password);
        Logger logger = Logger.getLogger(Case000418.class.getName());
        logger.info("authentication event recorded");
        return user;
    }
}
