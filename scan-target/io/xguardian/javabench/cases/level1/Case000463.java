package io.xguardian.javabench.cases.level1;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class Case000463 {
    public Object run(HttpServletResponse response, String sessionId) throws Exception {
        Cookie cookie = new Cookie("session", sessionId);
        cookie.setPath("/");
        response.addCookie(cookie);
        return cookie;
    }
}
