package org.javadeep.benchmark.cases.level2;

import org.javadeep.benchmark.support.BenchSupport;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000546 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        URI uri = URI.create(value);
        if (!BenchSupport.allowedHost(uri)) throw new SecurityException("destination not allowed");
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        return HttpClient.newHttpClient().sendAsync(request, java.net.http.HttpResponse.BodyHandlers.discarding());
    }
}
