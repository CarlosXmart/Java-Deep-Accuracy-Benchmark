package io.xguardian.javabench.cases.level5;

import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;
import java.util.logging.Logger;

public class Case000157 {
    public Object run(String password, HttpServletResponse response) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(password);
        response.sendError(500, "authentication failed; password=" + value);
        return null;
    }
}
