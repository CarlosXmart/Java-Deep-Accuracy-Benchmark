package io.xguardian.javabench.cases.level3;

import javax.crypto.Cipher;

public class Case000230 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return Cipher.getInstance("AES/GCM/NoPadding");
    }

    private String relay(String value) {
        return value;
    }
}
