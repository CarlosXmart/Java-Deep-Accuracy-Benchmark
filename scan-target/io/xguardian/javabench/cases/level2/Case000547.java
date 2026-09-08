package io.xguardian.javabench.cases.level2;

import io.xguardian.javabench.support.BenchSupport;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000547 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        return new URL(value).openConnection();
    }
}
