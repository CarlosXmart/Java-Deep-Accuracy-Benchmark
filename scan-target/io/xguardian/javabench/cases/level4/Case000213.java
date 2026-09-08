package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000213 {
    public Object run(byte[] suppliedKey, HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        byte[] key = "benchmark-key-16".getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(key, "AES");
    }
}
