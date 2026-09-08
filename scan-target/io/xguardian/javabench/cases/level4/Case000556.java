package io.xguardian.javabench.cases.level4;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000556 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        URI uri = URI.create(value);
        if (!BenchSupport.allowedHost(uri)) throw new SecurityException("destination not allowed");
        HttpRequest outboundRequest = HttpRequest.newBuilder(uri).GET().build();
        return HttpClient.newHttpClient().sendAsync(outboundRequest, java.net.http.HttpResponse.BodyHandlers.discarding());
    }
}
