package io.xguardian.javabench.cases.level1;

import java.security.MessageDigest;

public class Case000241 {
    public Object run(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        return digest.digest(input.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
