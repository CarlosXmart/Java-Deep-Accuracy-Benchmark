package io.xguardian.javabench.cases.level5;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000217 {
    public Object run(byte[] suppliedKey, String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        byte[] key = "benchmark-key-16".getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(key, "AES");
    }
}
