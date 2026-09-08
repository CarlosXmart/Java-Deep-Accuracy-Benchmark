package org.javadeep.benchmark.cases.level5;

import java.security.MessageDigest;

public class Case000257 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        MessageDigest digest = MessageDigest.getInstance("MD5");
        return digest.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
