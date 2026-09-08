package io.xguardian.javabench.cases.level5;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class Case000200 {
    public Object run(String token) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(token);
        return new URL("https://api.example.test/session?token=" + URLEncoder.encode(value, StandardCharsets.UTF_8));
    }
}
