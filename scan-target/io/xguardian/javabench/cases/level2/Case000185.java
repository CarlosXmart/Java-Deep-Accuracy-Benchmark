package io.xguardian.javabench.cases.level2;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000185 {
    public Object run(String token) throws Exception {
        String value = token == null ? "" : token.trim();
        URI uri = URI.create("http://api.example.test/session?token=" + URLEncoder.encode(value, StandardCharsets.UTF_8));
        return HttpRequest.newBuilder(uri).GET().build();
    }
}
