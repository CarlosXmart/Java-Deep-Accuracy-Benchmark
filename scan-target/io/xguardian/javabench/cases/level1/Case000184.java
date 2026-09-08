package io.xguardian.javabench.cases.level1;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000184 {
    public Object run(String input) throws Exception {
        return new URL("https://example.test/session");
    }
}
