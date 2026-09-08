package org.javadeep.benchmark.cases.level1;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000122 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        if (!BenchSupport.headerValue(input)) throw new SecurityException("invalid header value");
        response.setHeader("X-Trace", input);
        return null;
    }
}
