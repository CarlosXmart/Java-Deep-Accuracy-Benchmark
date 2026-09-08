package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

public class Case000313 {
    public Object run(HttpServletRequest request, HttpServletResponse response, Map<String, String> accountState) throws Exception {
        String requested = request.getParameter("email");
        if ("POST".equalsIgnoreCase(request.getMethod())) accountState.put("email", requested);
        return null;
    }
}
