package io.xguardian.javabench.cases.level1;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000201 {
    public Object run(byte[] suppliedKey, String input) throws Exception {
        byte[] key = "benchmark-key-16".getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(key, "AES");
    }
}
