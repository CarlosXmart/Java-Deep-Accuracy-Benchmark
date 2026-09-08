package io.xguardian.javabench.cases.level1;

import javax.crypto.Cipher;

public class Case000224 {
    public Object run(String input) throws Exception {
        return Cipher.getInstance("ChaCha20-Poly1305");
    }
}
