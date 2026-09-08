package io.xguardian.javabench.cases.level3;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000191 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return new URL("http://example.test/session?token=" + value);
    }

    private String relay(String value) {
        return value;
    }
}
