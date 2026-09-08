package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Case000476 {
    public Object run(HttpServletResponse response, String sessionId) throws Exception {
        Cookie cookie = new Cookie("session", sessionId);
        cookie.setSecure(true);
        cookie.setPath("/");
        response.addCookie(cookie);
        return cookie;
    }
}
