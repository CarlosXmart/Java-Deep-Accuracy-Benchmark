package org.javadeep.benchmark.cases.level1;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000222 {
    public Object run() throws Exception {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }
}
