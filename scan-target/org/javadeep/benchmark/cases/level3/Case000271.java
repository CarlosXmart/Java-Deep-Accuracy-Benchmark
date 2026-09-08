package org.javadeep.benchmark.cases.level3;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000271 {
    public Object run() throws Exception {
        return weakValue();
    }

    private long weakValue() { return (long) (Math.random() * 1_000_000_000L); }
}
