package io.xguardian.javabench.cases.level1;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000124 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String encoded = URLEncoder.encode(input == null ? "" : input, StandardCharsets.UTF_8);
        response.addHeader("X-Trace", encoded);
        return null;
    }
}
