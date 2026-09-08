package io.xguardian.javabench.cases.level2;

import java.security.SecureRandom;
import java.util.Random;

public class Case000266 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        SecureRandom random = new SecureRandom();
        return random.nextLong();
    }
}
