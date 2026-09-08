package org.javadeep.benchmark.cases.level2;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000186 {
    public Object run(String token) throws Exception {
        String value = token == null ? "" : token.trim();
        URI uri = URI.create("https://api.example.test/session");
        String body = "token=" + URLEncoder.encode(value, StandardCharsets.UTF_8);
        return HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(body)).build();
    }
}
