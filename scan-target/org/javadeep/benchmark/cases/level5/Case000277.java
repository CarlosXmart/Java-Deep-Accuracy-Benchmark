package org.javadeep.benchmark.cases.level5;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000277 {
    public Object run() throws Exception {
        return Holder.create().nextLong();
    }

    private static final class Holder {
        static Random create() { return new Random(); }
    }
}
