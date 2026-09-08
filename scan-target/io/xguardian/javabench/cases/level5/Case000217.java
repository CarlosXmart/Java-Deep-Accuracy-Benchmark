package io.xguardian.javabench.cases.level5;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000217 {
    public Object run(byte[] suppliedKey) throws Exception {
        Supplier<byte[]> keySupplier = () -> "benchmark-key-16".getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(keySupplier.get(), "AES");
    }
}
