package org.javadeep.benchmark.cases.level4;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000553 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        URI uri = URI.create(value);
        HttpRequest outboundRequest = HttpRequest.newBuilder(uri).GET().build();
        return HttpClient.newHttpClient().sendAsync(outboundRequest, java.net.http.HttpResponse.BodyHandlers.discarding());
    }
}
