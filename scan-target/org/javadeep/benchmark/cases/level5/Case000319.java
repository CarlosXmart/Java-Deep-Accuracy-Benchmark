package org.javadeep.benchmark.cases.level5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

public class Case000319 {
    public Object run(HttpServletRequest request, HttpServletResponse response, Map<String, String> accountState) throws Exception {
        BiConsumer<String, String> change = accountState::put;
        change.accept("displayName", request.getParameter("displayName"));
        return null;
    }
}
