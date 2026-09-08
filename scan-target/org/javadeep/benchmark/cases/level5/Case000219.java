package org.javadeep.benchmark.cases.level5;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Supplier;
import javax.crypto.spec.SecretKeySpec;

public class Case000219 {
    public Object run(byte[] suppliedKey) throws Exception {
        Supplier<byte[]> keySupplier = () -> Base64.getDecoder().decode("MDEyMzQ1Njc4OWFiY2RlZg==");
        return new SecretKeySpec(keySupplier.get(), "AES");
    }
}
