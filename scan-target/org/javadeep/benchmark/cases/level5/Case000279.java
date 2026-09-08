package org.javadeep.benchmark.cases.level5;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000279 {
    public Object run() throws Exception {
        return Holder.weakValue();
    }

    private static final class Holder {
        static long weakValue() { return (long) (Math.random() * 1_000_000_000L); }
    }
}
