package org.javadeep.benchmark.cases.level5;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000240 {
    public Object run() throws Exception {
        Supplier<String> algorithm = () -> "ChaCha20-Poly1305";
        return Cipher.getInstance(algorithm.get());
    }
}
