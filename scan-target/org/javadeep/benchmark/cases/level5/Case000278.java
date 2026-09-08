package org.javadeep.benchmark.cases.level5;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000278 {
    public Object run() throws Exception {
        return Holder.create().nextLong();
    }

    private static final class Holder {
        static SecureRandom create() { return new SecureRandom(); }
    }
}
