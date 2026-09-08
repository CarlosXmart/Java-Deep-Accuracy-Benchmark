package io.xguardian.javabench.cases.level2;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class Case000566 {
    public Object run(HttpServletResponse response, String sessionId) throws Exception {
        Cookie cookie = new Cookie("session", sessionId);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return cookie;
    }
}
