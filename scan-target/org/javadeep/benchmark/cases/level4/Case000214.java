package org.javadeep.benchmark.cases.level4;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000214 {
    public Object run(byte[] suppliedKey) throws Exception {
        String configured = System.getProperty("benchmark.crypto.key");
        if (configured == null || configured.length() < 16) throw new IllegalStateException("external key required");
        return new SecretKeySpec(configured.getBytes(StandardCharsets.UTF_8), "AES");
    }
}
