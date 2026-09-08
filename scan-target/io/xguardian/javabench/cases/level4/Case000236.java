package io.xguardian.javabench.cases.level4;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000236 {
    public Object run() throws Exception {
        String algorithm = Map.of("profile", "ChaCha20-Poly1305").get("profile");
        return Cipher.getInstance(algorithm);
    }
}
