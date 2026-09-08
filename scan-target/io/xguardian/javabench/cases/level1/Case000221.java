package io.xguardian.javabench.cases.level1;

import javax.crypto.Cipher;

public class Case000221 {
    public Object run(String input) throws Exception {
        return Cipher.getInstance("DES/ECB/PKCS5Padding");
    }
}
