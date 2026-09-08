package io.xguardian.javabench.cases.level3;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000470 {
    public Object run(String sessionId, HttpServletResponse response) throws Exception {
        Cookie cookie = buildCookie(value);
        response.addCookie(cookie);
        return cookie;
    }

    private Cookie buildCookie(String value) {
        Cookie cookie = new Cookie("session", value);
        cookie.setSecure(true);
        return cookie;
    }
}
