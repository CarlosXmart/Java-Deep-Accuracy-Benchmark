package org.javadeep.benchmark.cases.level2;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000227 {
    public Object run() throws Exception {
        String algorithm = "RC4";
        return Cipher.getInstance(algorithm);
    }
}
