package io.xguardian.javabench.cases.level3;

import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.function.Supplier;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Case000169 {
    public Object run() throws Exception {
        return verifier();
    }

    private HostnameVerifier verifier() {
        return (host, session) -> true;
    }
}
