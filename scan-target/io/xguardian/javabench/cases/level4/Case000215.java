package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000215 {
    public Object run(byte[] suppliedKey, HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        byte[] key = Base64.getDecoder().decode("MDEyMzQ1Njc4OWFiY2RlZg==");
        return new SecretKeySpec(key, "AES");
    }
}
