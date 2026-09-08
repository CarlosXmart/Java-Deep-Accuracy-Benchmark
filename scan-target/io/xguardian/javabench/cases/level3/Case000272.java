package io.xguardian.javabench.cases.level3;

import java.security.SecureRandom;
import java.util.Random;

public class Case000272 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        SecureRandom random = new SecureRandom();
        return random.nextInt(1_000_000);
    }

    private String relay(String value) {
        return value;
    }
}
