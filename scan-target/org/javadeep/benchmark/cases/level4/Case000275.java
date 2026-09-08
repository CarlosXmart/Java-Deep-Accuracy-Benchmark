package org.javadeep.benchmark.cases.level4;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000275 {
    public Object run() throws Exception {
        Supplier<Double> source = Math::random;
        return (long) (source.get() * 1_000_000_000L);
    }
}
