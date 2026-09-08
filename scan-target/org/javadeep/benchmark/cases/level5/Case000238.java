package org.javadeep.benchmark.cases.level5;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000238 {
    public Object run() throws Exception {
        Supplier<String> algorithm = () -> "AES/GCM/NoPadding";
        return Cipher.getInstance(algorithm.get());
    }
}
