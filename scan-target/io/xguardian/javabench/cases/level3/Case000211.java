package io.xguardian.javabench.cases.level3;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000211 {
    public Object run(byte[] suppliedKey) throws Exception {
        byte[] key = configuredKey();
        return new SecretKeySpec(key, "AES");
    }

    private byte[] configuredKey() {
        return Base64.getDecoder().decode("MDEyMzQ1Njc4OWFiY2RlZg==");
    }
}
