package io.xguardian.javabench.cases.level4;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Case000133 {
    public Object run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String value = request.getParameter("value");
        response.setHeader("X-Trace", value);
        return null;
    }
}
