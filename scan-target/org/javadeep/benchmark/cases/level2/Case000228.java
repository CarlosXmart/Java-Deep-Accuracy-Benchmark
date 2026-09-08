package org.javadeep.benchmark.cases.level2;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000228 {
    public Object run() throws Exception {
        String algorithm = "ChaCha20-Poly1305";
        return Cipher.getInstance(algorithm);
    }
}
