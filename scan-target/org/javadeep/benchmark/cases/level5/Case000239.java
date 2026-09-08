package org.javadeep.benchmark.cases.level5;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000239 {
    public Object run() throws Exception {
        Supplier<String> algorithm = () -> "RC4";
        return Cipher.getInstance(algorithm.get());
    }
}
