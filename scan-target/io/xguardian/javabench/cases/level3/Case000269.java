package io.xguardian.javabench.cases.level3;

import java.security.SecureRandom;
import java.util.Random;

public class Case000269 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return new Random().nextLong();
    }

    private String relay(String value) {
        return value;
    }
}
