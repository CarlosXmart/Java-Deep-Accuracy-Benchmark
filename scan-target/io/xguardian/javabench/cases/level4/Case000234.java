package io.xguardian.javabench.cases.level4;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000234 {
    public Object run() throws Exception {
        String algorithm = Map.of("profile", "AES/GCM/NoPadding").get("profile");
        return Cipher.getInstance(algorithm);
    }
}
