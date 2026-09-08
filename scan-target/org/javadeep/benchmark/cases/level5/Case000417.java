package org.javadeep.benchmark.cases.level5;

import java.util.function.Function;
import java.util.logging.Logger;

public class Case000417 {
    public Object run(String password, String user) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(password);
        Logger logger = Logger.getLogger(Case000417.class.getName());
        logger.info("login user=" + user + " password=" + value);
        return user;
    }
}
