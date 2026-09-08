package org.javadeep.benchmark.cases.level4;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000233 {
    public Object run() throws Exception {
        String algorithm = Map.of("profile", "DES/ECB/PKCS5Padding").get("profile");
        return Cipher.getInstance(algorithm);
    }
}
