package io.xguardian.javabench.cases.level1;

import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.function.Supplier;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Case000161 {
    public Object run() throws Exception {
        TrustManager[] managers = { trustAll() };
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, managers, new java.security.SecureRandom());
        return context.getSocketFactory();
    }

    private X509TrustManager trustAll() {
        return new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
            public void checkClientTrusted(X509Certificate[] chain, String authType) {}
            public void checkServerTrusted(X509Certificate[] chain, String authType) {}
        };
    }
}
