package io.xguardian.javabench.cases.level5;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000197 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        URI uri = URI.create("http://" + value);
        return HttpRequest.newBuilder(uri).GET().build();
    }
}
