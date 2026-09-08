package org.javadeep.benchmark.cases.level1;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000561 {
    public Object run(String sessionId, HttpServletResponse response) throws Exception {
        Cookie cookie = new Cookie("session", sessionId);
        cookie.setSecure(true);
        response.addCookie(cookie);
        return cookie;
    }
}
