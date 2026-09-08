package org.javadeep.benchmark.cases.level3;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000210 {
    public Object run(byte[] suppliedKey) throws Exception {
        return externalKey(suppliedKey);
    }

    private SecretKeySpec externalKey(byte[] key) {
        if (key == null || key.length < 16) throw new IllegalArgumentException("key too short");
        return new SecretKeySpec(key.clone(), "AES");
    }
}
