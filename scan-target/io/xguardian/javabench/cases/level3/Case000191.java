package io.xguardian.javabench.cases.level3;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000191 {
    public Object run(String token) throws Exception {
        String value = relay(token);
        URI uri = URI.create("http://api.example.test/session");
        return HttpRequest.newBuilder(uri).header("Authorization", "Bearer " + value).GET().build();
    }

    private String relay(String value) {
        return value;
    }
}
