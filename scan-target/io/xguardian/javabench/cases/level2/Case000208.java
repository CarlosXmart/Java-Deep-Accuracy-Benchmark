package io.xguardian.javabench.cases.level2;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000208 {
    public Object run(byte[] suppliedKey, String input) throws Exception {
        String value = input == null ? "" : input.trim();
        if (suppliedKey == null || suppliedKey.length < 16) throw new IllegalArgumentException("key too short");
        return new SecretKeySpec(suppliedKey.clone(), "AES");
    }
}
