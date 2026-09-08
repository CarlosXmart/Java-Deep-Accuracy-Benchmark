package io.xguardian.javabench.cases.level5;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000480 {
    public Object run(String sessionId, HttpServletResponse response) throws Exception {
        Function<String, Cookie> factory = value -> {
            Cookie cookie = new Cookie("session", value);
            cookie.setSecure(true);
            return cookie;
        };
        Cookie cookie = factory.apply(value);
        response.addCookie(cookie);
        return cookie;
    }
}
