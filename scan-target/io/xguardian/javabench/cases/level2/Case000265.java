package io.xguardian.javabench.cases.level2;

import java.security.SecureRandom;
import java.util.Random;

public class Case000265 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        return new Random().nextLong();
    }
}
