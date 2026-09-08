package org.javadeep.benchmark.cases.level4;

import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.function.Supplier;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Case000174 {
    public Object run() throws Exception {
        HttpsURLConnection connection = (HttpsURLConnection) new URL("https://example.test").openConnection();
        return connection;
    }
}
