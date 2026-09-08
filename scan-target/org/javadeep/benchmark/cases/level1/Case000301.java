package org.javadeep.benchmark.cases.level1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

public class Case000301 {
    public Object run(HttpServletRequest request, HttpServletResponse response, Map<String, String> accountState) throws Exception {
        accountState.put("email", request.getParameter("email"));
        return null;
    }
}
