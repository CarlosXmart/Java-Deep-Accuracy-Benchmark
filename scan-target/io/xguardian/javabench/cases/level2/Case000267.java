package io.xguardian.javabench.cases.level2;

import java.security.SecureRandom;
import java.util.Random;

public class Case000267 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        return (long) (Math.random() * 1_000_000_000L);
    }
}
