package io.xguardian.javabench.cases.level2;

import javax.crypto.Cipher;

public class Case000227 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        return Cipher.getInstance("RC4");
    }
}
