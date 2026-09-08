package io.xguardian.javabench.cases.level3;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000209 {
    public Object run(byte[] suppliedKey) throws Exception {
        byte[] key = configuredKey();
        return new SecretKeySpec(key, "AES");
    }

    private byte[] configuredKey() {
        return "benchmark-key-16".getBytes(StandardCharsets.UTF_8);
    }
}
