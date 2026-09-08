package io.xguardian.javabench.cases.level5;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000218 {
    public Object run(byte[] suppliedKey, String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        if (suppliedKey == null || suppliedKey.length < 16) throw new IllegalArgumentException("key too short");
        return new SecretKeySpec(suppliedKey.clone(), "AES");
    }
}
