package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000193 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("token");
        URI uri = URI.create("http://api.example.test/session");
        String body = "token=" + URLEncoder.encode(value, StandardCharsets.UTF_8);
        return HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(body)).build();
    }
}
