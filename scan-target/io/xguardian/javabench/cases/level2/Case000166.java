package io.xguardian.javabench.cases.level2;

import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.function.Supplier;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Case000166 {
    public Object run() throws Exception {
        HostnameVerifier verifier = HttpsURLConnection.getDefaultHostnameVerifier();
        return verifier;
    }
}
