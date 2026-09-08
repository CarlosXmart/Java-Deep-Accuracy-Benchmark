package io.xguardian.javabench.cases.level3;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000189 {
    public Object run(String token) throws Exception {
        String value = relay(token);
        URI uri = URI.create("http://api.example.test/session");
        String body = "token=" + URLEncoder.encode(value, StandardCharsets.UTF_8);
        return HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(body)).build();
    }

    private String relay(String value) {
        return value;
    }
}
