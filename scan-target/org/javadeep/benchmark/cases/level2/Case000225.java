package org.javadeep.benchmark.cases.level2;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000225 {
    public Object run() throws Exception {
        String algorithm = "DES/ECB/PKCS5Padding";
        return Cipher.getInstance(algorithm);
    }
}
