package io.xguardian.javabench.cases.level5;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Case000219 {
    public Object run(byte[] suppliedKey, String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        byte[] key = Base64.getDecoder().decode("MDEyMzQ1Njc4OWFiY2RlZg==");
        return new SecretKeySpec(key, "AES");
    }
}
