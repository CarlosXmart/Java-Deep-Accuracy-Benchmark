package io.xguardian.javabench.cases.level1;

import io.xguardian.javabench.support.BenchSupport;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000543 {
    public Object run(String input) throws Exception {
        return new URL(input).openConnection();
    }
}
