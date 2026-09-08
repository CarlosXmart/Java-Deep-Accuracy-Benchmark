package io.xguardian.javabench.cases.level2;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000188 {
    public Object run(String token) throws Exception {
        String value = token == null ? "" : token.trim();
        URI uri = URI.create("https://api.example.test/session");
        return HttpRequest.newBuilder(uri).header("Authorization", "Bearer " + value).GET().build();
    }
}
