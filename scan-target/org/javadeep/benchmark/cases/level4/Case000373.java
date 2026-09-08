package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000373 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        Class<?> type = Class.forName(value);
        return type.getDeclaredConstructor().newInstance();
    }
}
