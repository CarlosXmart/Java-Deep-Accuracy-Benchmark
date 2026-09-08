package io.xguardian.javabench.cases.level1;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000124 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("trace");
        String encoded = URLEncoder.encode(value == null ? "" : value, StandardCharsets.UTF_8);
        response.setHeader("X-Benchmark", encoded);
        return null;
    }
}
