package io.xguardian.javabench.cases.level1;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000183 {
    public Object run(String token) throws Exception {
        URI uri = URI.create("http://api.example.test/session");
        return HttpRequest.newBuilder(uri).header("Authorization", "Bearer " + token).GET().build();
    }
}
