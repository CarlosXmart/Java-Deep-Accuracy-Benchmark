package io.xguardian.javabench.cases.level2;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000208 {
    public Object run(byte[] suppliedKey) throws Exception {
        byte[] key = suppliedKey == null ? null : suppliedKey.clone();
        requireKey(key);
        return new SecretKeySpec(key, "AES");
    }

    private void requireKey(byte[] key) {
        if (key == null || key.length < 16) throw new IllegalArgumentException("key too short");
    }
}
