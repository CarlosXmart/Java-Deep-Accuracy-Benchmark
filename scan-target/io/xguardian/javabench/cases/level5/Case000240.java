package io.xguardian.javabench.cases.level5;

import javax.crypto.Cipher;

public class Case000240 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        return Cipher.getInstance("ChaCha20-Poly1305");
    }
}
