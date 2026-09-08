package io.xguardian.javabench.cases.level3;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class Case000469 {
    public Object run(HttpServletResponse response, String sessionId) throws Exception {
        Cookie cookie = new Cookie("session", sessionId);
        response.addCookie(cookie);
        return cookie;
    }

    private String relay(String value) {
        return value;
    }
}
