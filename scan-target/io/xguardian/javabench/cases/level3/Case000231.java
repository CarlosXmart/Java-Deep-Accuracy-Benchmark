package io.xguardian.javabench.cases.level3;

import javax.crypto.Cipher;

public class Case000231 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return Cipher.getInstance("RC4");
    }

    private String relay(String value) {
        return value;
    }
}
