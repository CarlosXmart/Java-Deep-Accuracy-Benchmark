package org.javadeep.benchmark.cases.level5;

import java.security.MessageDigest;

public class Case000260 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        return digest.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
