package org.javadeep.benchmark.cases.level2;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000467 {
    public Object run(String sessionId, HttpServletResponse response) throws Exception {
        String value = sessionId == null ? "" : sessionId.trim();
        Cookie cookie = new Cookie("session", value);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return cookie;
    }
}
