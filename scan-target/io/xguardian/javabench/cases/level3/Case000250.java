package io.xguardian.javabench.cases.level3;

import java.security.MessageDigest;

public class Case000250 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }

    private String relay(String value) {
        return value;
    }
}
