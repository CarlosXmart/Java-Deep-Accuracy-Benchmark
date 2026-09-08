package org.javadeep.benchmark.cases.level1;

import java.security.MessageDigest;

public class Case000242 {
    public Object run(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(input.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
