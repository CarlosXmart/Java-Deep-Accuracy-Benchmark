package io.xguardian.javabench.cases.level1;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000181 {
    public Object run(String token) throws Exception {
        URI uri = URI.create("http://api.example.test/session?token=" + URLEncoder.encode(token, StandardCharsets.UTF_8));
        return HttpRequest.newBuilder(uri).GET().build();
    }
}
