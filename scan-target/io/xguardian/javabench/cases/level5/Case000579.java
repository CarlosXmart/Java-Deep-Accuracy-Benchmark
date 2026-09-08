package io.xguardian.javabench.cases.level5;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000579 {
    public Object run(String sessionId, HttpServletResponse response) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(sessionId);
        Function<String, Cookie> factory = item -> {
            Cookie cookie = new Cookie("session", item);
            return cookie;
        };
        Cookie cookie = factory.apply(value);
        response.addCookie(cookie);
        return cookie;
    }
}
