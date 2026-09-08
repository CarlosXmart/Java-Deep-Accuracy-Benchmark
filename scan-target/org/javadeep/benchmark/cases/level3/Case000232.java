package org.javadeep.benchmark.cases.level3;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000232 {
    public Object run() throws Exception {
        return Cipher.getInstance(algorithm());
    }

    private String algorithm() {
        return "ChaCha20-Poly1305";
    }
}
