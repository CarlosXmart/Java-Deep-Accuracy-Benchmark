package io.xguardian.javabench.cases.level5;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class Case000138 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(input);
        if (!BenchSupport.headerValue(value)) throw new SecurityException("invalid header value");
        response.setHeader("X-Trace", value);
        return null;
    }
}
