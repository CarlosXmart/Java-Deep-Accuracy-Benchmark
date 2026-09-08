package org.javadeep.benchmark.cases.level1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000264 {
    public Object run() throws Exception {
        return new SecureRandom().nextLong();
    }
}
