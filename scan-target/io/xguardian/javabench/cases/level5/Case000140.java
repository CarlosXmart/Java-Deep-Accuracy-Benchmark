package io.xguardian.javabench.cases.level5;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class Case000140 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(input);
        String encoded = URLEncoder.encode(value == null ? "" : value, StandardCharsets.UTF_8);
        response.addHeader("X-Trace", encoded);
        return null;
    }
}
