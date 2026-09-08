package io.xguardian.javabench.cases.level3;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000192 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return new URL("https://example.test/session");
    }

    private String relay(String value) {
        return value;
    }
}
