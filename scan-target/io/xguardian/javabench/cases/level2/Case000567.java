package io.xguardian.javabench.cases.level2;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class Case000567 {
    public Object run(HttpServletResponse response, String sessionId) throws Exception {
        Cookie cookie = new Cookie("session", sessionId);
        cookie.setSecure(true);
        response.addCookie(cookie);
        return cookie;
    }
}
