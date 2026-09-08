package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000196 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("token");
        URI uri = URI.create("https://api.example.test/session");
        return HttpRequest.newBuilder(uri).header("Authorization", "Bearer " + value).GET().build();
    }
}
