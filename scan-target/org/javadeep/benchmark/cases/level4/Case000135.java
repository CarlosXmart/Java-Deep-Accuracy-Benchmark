package org.javadeep.benchmark.cases.level4;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000135 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("trace");
        response.addHeader("X-Trace", value);
        return null;
    }
}
