package org.javadeep.benchmark.cases.level2;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000266 {
    public Object run() throws Exception {
        SecureRandom random = new SecureRandom();
        return random.nextLong();
    }
}
