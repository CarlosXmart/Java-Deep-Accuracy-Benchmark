package io.xguardian.javabench.cases.level2;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000226 {
    public Object run() throws Exception {
        String algorithm = "AES/GCM/NoPadding";
        return Cipher.getInstance(algorithm);
    }
}
