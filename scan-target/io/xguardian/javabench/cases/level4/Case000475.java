package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000475 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("session");
        Cookie cookie = new Cookie("session", value);
        response.addCookie(cookie);
        return cookie;
    }
}
