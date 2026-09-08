package io.xguardian.javabench.cases.level3;

import io.xguardian.javabench.support.BenchSupport;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000551 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return new URL(value).openConnection();
    }

    private String relay(String value) {
        return value;
    }
}
