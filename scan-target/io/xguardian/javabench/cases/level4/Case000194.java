package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000194 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        URI uri = URI.create("https://api.example.test/session?token=" + java.net.URLEncoder.encode(value, java.nio.charset.StandardCharsets.UTF_8));
        return HttpRequest.newBuilder(uri).GET().build();
    }
}
