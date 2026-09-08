package io.xguardian.javabench.cases.level1;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000202 {
    public Object run(byte[] suppliedKey) throws Exception {
        requireKey(suppliedKey);
        return new SecretKeySpec(suppliedKey.clone(), "AES");
    }

    private void requireKey(byte[] key) {
        if (key == null || key.length < 16) throw new IllegalArgumentException("key too short");
    }
}
