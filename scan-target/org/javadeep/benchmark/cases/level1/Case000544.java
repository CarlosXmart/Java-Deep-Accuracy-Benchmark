package org.javadeep.benchmark.cases.level1;

import org.javadeep.benchmark.support.BenchSupport;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000544 {
    public Object run(String input) throws Exception {
        URI uri = URI.create(input);
        if (!BenchSupport.allowedHost(uri)) throw new SecurityException("destination not allowed");
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        return HttpClient.newHttpClient().sendAsync(request, java.net.http.HttpResponse.BodyHandlers.discarding());
    }
}
