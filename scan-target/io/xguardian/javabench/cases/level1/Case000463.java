package io.xguardian.javabench.cases.level1;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000463 {
    public Object run(String sessionId, HttpServletResponse response) throws Exception {
        Cookie cookie = new Cookie("session", sessionId);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return cookie;
    }
}
