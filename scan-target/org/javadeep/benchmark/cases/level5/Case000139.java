package org.javadeep.benchmark.cases.level5;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class Case000139 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(input);
        response.addHeader("X-Trace", value);
        return null;
    }
}
