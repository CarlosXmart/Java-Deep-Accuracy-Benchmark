package org.javadeep.benchmark.cases.level2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

public class Case000307 {
    public Object run(HttpServletRequest request, HttpServletResponse response, Map<String, String> accountState) throws Exception {
        String requested = request.getParameter("displayName");
        accountState.put("displayName", requested);
        return null;
    }
}
