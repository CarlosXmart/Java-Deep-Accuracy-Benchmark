package io.xguardian.javabench.cases.level1;

import javax.crypto.Cipher;

public class Case000222 {
    public Object run(String input) throws Exception {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }
}
