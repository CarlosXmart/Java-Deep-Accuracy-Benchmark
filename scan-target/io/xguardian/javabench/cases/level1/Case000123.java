package io.xguardian.javabench.cases.level1;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000123 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        response.addHeader("X-Trace", input);
        return null;
    }
}
