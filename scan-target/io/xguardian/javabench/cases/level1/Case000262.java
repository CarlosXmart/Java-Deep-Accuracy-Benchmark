package io.xguardian.javabench.cases.level1;

import java.security.SecureRandom;
import java.util.Random;

public class Case000262 {
    public Object run(String input) throws Exception {
        SecureRandom random = new SecureRandom();
        return random.nextLong();
    }
}
