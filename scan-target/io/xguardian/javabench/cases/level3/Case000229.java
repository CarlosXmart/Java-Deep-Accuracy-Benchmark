package io.xguardian.javabench.cases.level3;

import javax.crypto.Cipher;

public class Case000229 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return Cipher.getInstance("DES/ECB/PKCS5Padding");
    }

    private String relay(String value) {
        return value;
    }
}
