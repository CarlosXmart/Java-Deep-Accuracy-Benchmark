package org.javadeep.benchmark.cases.level5;

import java.util.function.Function;
import java.util.logging.Logger;

public class Case000419 {
    public Object run(String password, String user) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(password);
        Logger logger = Logger.getLogger(Case000419.class.getName());
        logger.info(String.format("credentials %s:%s", user, value));
        return user;
    }
}
