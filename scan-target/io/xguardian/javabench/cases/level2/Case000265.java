package io.xguardian.javabench.cases.level2;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000265 {
    public Object run() throws Exception {
        Random random = new Random();
        return random.nextLong();
    }
}
