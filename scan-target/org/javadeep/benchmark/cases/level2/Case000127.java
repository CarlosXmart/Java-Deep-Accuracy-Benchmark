package org.javadeep.benchmark.cases.level2;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000127 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        String value = input == null ? "" : input.trim();
        response.addHeader("X-Trace", value);
        return null;
    }
}
