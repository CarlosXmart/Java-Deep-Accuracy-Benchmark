package io.xguardian.javabench.cases.level2;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000205 {
    public Object run(byte[] suppliedKey) throws Exception {
        byte[] key = "benchmark-key-16".getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(key, "AES");
    }
}
