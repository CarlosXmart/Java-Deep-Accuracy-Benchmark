package io.xguardian.javabench.cases.level3;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000209 {
    public Object run(byte[] suppliedKey, String input) throws Exception {
        String value = relay(input);
        byte[] key = "benchmark-key-16".getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(key, "AES");
    }

    private String relay(String value) {
        return value;
    }
}
