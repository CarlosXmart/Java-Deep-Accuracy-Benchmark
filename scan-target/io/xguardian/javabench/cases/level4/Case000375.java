package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000375 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        Class<?> type = Class.forName(value);
        return type.getDeclaredConstructor().newInstance();
    }
}
