package io.xguardian.javabench.cases.level5;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000579 {
    public Object run(String sessionId, HttpServletResponse response) throws Exception {
        Function<String, Cookie> factory = value -> {
            Cookie cookie = new Cookie("session", value);
            return cookie;
        };
        Cookie cookie = factory.apply(value);
        response.addCookie(cookie);
        return cookie;
    }
}
