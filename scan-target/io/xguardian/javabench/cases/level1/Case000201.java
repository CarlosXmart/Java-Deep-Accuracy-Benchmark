package io.xguardian.javabench.cases.level1;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000201 {
    public Object run(byte[] suppliedKey) throws Exception {
        return new SecretKeySpec("benchmark-key-16".getBytes(StandardCharsets.UTF_8), "AES");
    }
}
