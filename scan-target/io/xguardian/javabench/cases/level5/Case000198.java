package io.xguardian.javabench.cases.level5;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class Case000198 {
    public Object run(String token) throws Exception {
        Function<String, String> relay = item -> item;
        String value = relay.apply(token);
        URI uri = URI.create("https://api.example.test/session");
        String body = "token=" + URLEncoder.encode(value, StandardCharsets.UTF_8);
        return HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(body)).build();
    }
}
