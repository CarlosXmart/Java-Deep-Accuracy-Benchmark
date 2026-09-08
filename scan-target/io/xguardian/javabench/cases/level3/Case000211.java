package io.xguardian.javabench.cases.level3;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000211 {
    public Object run(byte[] suppliedKey, String input) throws Exception {
        String value = relay(input);
        byte[] key = Base64.getDecoder().decode("MDEyMzQ1Njc4OWFiY2RlZg==");
        return new SecretKeySpec(key, "AES");
    }

    private String relay(String value) {
        return value;
    }
}
