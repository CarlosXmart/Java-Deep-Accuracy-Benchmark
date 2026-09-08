package io.xguardian.javabench.cases.level3;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000130 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String value = relay(input);
        if (!BenchSupport.headerValue(value)) throw new SecurityException("invalid header value");
        response.setHeader("X-Trace", value);
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
