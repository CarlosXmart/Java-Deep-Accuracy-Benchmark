package io.xguardian.javabench.cases.level5;

import javax.crypto.Cipher;

public class Case000237 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        return Cipher.getInstance("DES/ECB/PKCS5Padding");
    }
}
