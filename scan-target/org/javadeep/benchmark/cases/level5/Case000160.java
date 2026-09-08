package org.javadeep.benchmark.cases.level5;

import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;
import java.util.logging.Logger;

public class Case000160 {
    public Object run(String password, HttpServletResponse response) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(password);
        Logger.getLogger(Case000160.class.getName()).warning("request failed");
        response.sendError(500, "Request could not be completed");
        return null;
    }
}
