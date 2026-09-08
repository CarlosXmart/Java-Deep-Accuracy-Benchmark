package io.xguardian.javabench.cases.level3;

import javax.crypto.Cipher;

public class Case000232 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return Cipher.getInstance("ChaCha20-Poly1305");
    }

    private String relay(String value) {
        return value;
    }
}
