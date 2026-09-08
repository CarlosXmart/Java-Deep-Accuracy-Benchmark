package io.xguardian.javabench.cases.level3;

import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Case000172 {
    public Object run(String input) throws Exception {
        return HttpsURLConnection.getDefaultHostnameVerifier();
    }

    private String relay(String value) {
        return value;
    }
}
