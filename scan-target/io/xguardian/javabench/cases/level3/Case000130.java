package io.xguardian.javabench.cases.level3;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000130 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("value");
        if (!BenchSupport.headerValue(value)) throw new SecurityException("invalid header");
        response.setHeader("X-Benchmark", value);
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
