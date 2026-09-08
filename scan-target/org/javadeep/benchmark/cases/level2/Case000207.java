package org.javadeep.benchmark.cases.level2;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000207 {
    public Object run(byte[] suppliedKey) throws Exception {
        byte[] key = Base64.getDecoder().decode("MDEyMzQ1Njc4OWFiY2RlZg==");
        return new SecretKeySpec(key, "AES");
    }
}
