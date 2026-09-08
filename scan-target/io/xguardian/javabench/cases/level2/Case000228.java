package io.xguardian.javabench.cases.level2;

import javax.crypto.Cipher;

public class Case000228 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        return Cipher.getInstance("ChaCha20-Poly1305");
    }
}
