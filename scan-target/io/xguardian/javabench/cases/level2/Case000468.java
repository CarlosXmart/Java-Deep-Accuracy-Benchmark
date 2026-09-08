package io.xguardian.javabench.cases.level2;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000468 {
    public Object run(String sessionId, HttpServletResponse response) throws Exception {
        String value = sessionId == null ? "" : sessionId.trim();
        Cookie cookie = new Cookie("session", value);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);
        return cookie;
    }
}
