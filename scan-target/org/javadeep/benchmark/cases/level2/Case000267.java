package org.javadeep.benchmark.cases.level2;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000267 {
    public Object run() throws Exception {
        double value = Math.random();
        return (long) (value * 1_000_000_000L);
    }
}
