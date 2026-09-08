package io.xguardian.javabench.cases.level3;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class Case000191 {
    public Object run(String token) throws Exception {
        String value = relay(token);
        return new URL("http://api.example.test/session?token=" + URLEncoder.encode(value, StandardCharsets.UTF_8));
    }

    private String relay(String value) {
        return value;
    }
}
