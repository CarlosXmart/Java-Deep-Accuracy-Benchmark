package io.xguardian.javabench.cases.level3;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000132 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String value = relay(input);
        String encoded = URLEncoder.encode(value == null ? "" : value, StandardCharsets.UTF_8);
        response.addHeader("X-Trace", encoded);
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
