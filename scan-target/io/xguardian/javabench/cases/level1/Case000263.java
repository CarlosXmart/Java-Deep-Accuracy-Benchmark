package io.xguardian.javabench.cases.level1;

import java.security.SecureRandom;
import java.util.Random;

public class Case000263 {
    public Object run(String input) throws Exception {
        return (long) (Math.random() * 1_000_000_000L);
    }
}
