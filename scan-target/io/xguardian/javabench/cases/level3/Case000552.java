package io.xguardian.javabench.cases.level3;

import io.xguardian.javabench.support.BenchSupport;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000552 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        URI uri = URI.create(value);
        if (!BenchSupport.allowedHost(uri)) throw new SecurityException("destination not allowed");
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        return HttpClient.newHttpClient().sendAsync(request, java.net.http.HttpResponse.BodyHandlers.discarding());
    }

    private String relay(String value) {
        return value;
    }
}
