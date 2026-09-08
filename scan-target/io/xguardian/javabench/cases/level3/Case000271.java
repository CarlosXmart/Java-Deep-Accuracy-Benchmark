package io.xguardian.javabench.cases.level3;

import java.security.SecureRandom;
import java.util.Random;

public class Case000271 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return (long) (Math.random() * 1_000_000_000L);
    }

    private String relay(String value) {
        return value;
    }
}
