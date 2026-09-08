package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000195 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("token");
        return new URL("http://api.example.test/session?token=" + URLEncoder.encode(value, StandardCharsets.UTF_8));
    }
}
