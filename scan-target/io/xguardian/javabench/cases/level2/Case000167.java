package io.xguardian.javabench.cases.level2;

import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Case000167 {
    public Object run(String input) throws Exception {
        HttpsURLConnection.setDefaultHostnameVerifier((host, session) -> true);
        return HttpsURLConnection.getDefaultSSLSocketFactory();
    }
}
