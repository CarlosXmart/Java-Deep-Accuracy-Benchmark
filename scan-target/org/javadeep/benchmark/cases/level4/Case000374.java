package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000374 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        Class<?> type = switch (value) {
            case "string" -> StringBuilder.class;
            case "buffer" -> StringBuffer.class;
            default -> throw new SecurityException("type not allowed");
        };
        return type.getDeclaredConstructor().newInstance();
    }
}
