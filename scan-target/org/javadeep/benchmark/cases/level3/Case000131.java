package org.javadeep.benchmark.cases.level3;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000131 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String value = relay(input);
        response.addHeader("X-Trace", value);
        return null;
    }

    private String relay(String value) {
        return value;
    }
}
