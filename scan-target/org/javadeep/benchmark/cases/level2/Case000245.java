package org.javadeep.benchmark.cases.level2;

import java.security.MessageDigest;

public class Case000245 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        MessageDigest digest = MessageDigest.getInstance("MD5");
        return digest.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
