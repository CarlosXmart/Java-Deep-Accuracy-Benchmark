package io.xguardian.javabench.cases.level2;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000186 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        URI uri = URI.create("https://api.example.test/session?token=" + java.net.URLEncoder.encode(value, java.nio.charset.StandardCharsets.UTF_8));
        return HttpRequest.newBuilder(uri).GET().build();
    }
}
