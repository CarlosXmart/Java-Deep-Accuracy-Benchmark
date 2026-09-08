package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Case000195 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        return new URL("http://example.test/session?token=" + value);
    }
}
