package io.xguardian.javabench.cases.level5;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000198 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        URI uri = URI.create("https://api.example.test/session?token=" + java.net.URLEncoder.encode(value, java.nio.charset.StandardCharsets.UTF_8));
        return HttpRequest.newBuilder(uri).GET().build();
    }
}
