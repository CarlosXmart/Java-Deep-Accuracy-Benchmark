package io.xguardian.javabench.cases.level2;

import java.security.MessageDigest;

public class Case000246 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
