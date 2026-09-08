package org.javadeep.benchmark.cases.level2;

import java.security.MessageDigest;

public class Case000248 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        return digest.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
