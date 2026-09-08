package io.xguardian.javabench.cases.level1;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000203 {
    public Object run(byte[] suppliedKey) throws Exception {
        return new SecretKeySpec(Base64.getDecoder().decode("MDEyMzQ1Njc4OWFiY2RlZg=="), "AES");
    }
}
