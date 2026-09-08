package io.xguardian.javabench.cases.level3;

import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Case000170 {
    public Object run(String input) throws Exception {
        SSLContext context = SSLContext.getDefault();
        return context.getSocketFactory();
    }

    private String relay(String value) {
        return value;
    }
}
