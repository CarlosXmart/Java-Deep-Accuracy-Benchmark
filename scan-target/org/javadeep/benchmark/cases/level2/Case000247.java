package org.javadeep.benchmark.cases.level2;

import java.security.MessageDigest;

public class Case000247 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        return digest.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
