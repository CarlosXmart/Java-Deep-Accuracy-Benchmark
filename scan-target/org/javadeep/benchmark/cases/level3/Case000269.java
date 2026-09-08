package org.javadeep.benchmark.cases.level3;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000269 {
    public Object run() throws Exception {
        return weakRandom().nextLong();
    }

    private Random weakRandom() { return new Random(); }
}
