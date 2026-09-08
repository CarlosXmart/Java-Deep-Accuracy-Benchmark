package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000216 {
    public Object run(byte[] suppliedKey, HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        if (suppliedKey == null || suppliedKey.length < 16) throw new IllegalArgumentException("key too short");
        return new SecretKeySpec(suppliedKey.clone(), "AES");
    }
}
