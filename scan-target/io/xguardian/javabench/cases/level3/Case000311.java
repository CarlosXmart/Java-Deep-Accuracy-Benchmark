package io.xguardian.javabench.cases.level3;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

public class Case000311 {
    public Object run(HttpServletRequest request, HttpServletResponse response, Map<String, String> accountState) throws Exception {
        applyChange(accountState, "displayName", request.getParameter("displayName"));
        return null;
    }

    private void applyChange(Map<String, String> state, String key, String value) {
        state.put(key, value);
    }
}
