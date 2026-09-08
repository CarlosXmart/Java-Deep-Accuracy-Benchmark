package org.javadeep.benchmark.cases.level3;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000229 {
    public Object run() throws Exception {
        return Cipher.getInstance(algorithm());
    }

    private String algorithm() {
        return "DES/ECB/PKCS5Padding";
    }
}
