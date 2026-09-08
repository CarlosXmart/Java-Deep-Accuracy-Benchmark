package io.xguardian.javabench.cases.level1;

import java.security.MessageDigest;

public class Case000243 {
    public Object run(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        return digest.digest(input.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
