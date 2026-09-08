package io.xguardian.javabench.cases.level2;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000188 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        return new URL("https://example.test/session");
    }
}
