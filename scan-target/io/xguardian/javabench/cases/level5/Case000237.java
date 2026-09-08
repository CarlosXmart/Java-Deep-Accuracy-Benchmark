package io.xguardian.javabench.cases.level5;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000237 {
    public Object run() throws Exception {
        Supplier<String> algorithm = () -> "DES/ECB/PKCS5Padding";
        return Cipher.getInstance(algorithm.get());
    }
}
