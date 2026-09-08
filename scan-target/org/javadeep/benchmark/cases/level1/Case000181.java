package org.javadeep.benchmark.cases.level1;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000181 {
    public Object run(String token) throws Exception {
        URI uri = URI.create("http://api.example.test/session");
        String body = "token=" + URLEncoder.encode(token, StandardCharsets.UTF_8);
        return HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(body)).build();
    }
}
