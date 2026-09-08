package io.xguardian.javabench.cases.level5;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000280 {
    public Object run() throws Exception {
        return Holder.create().nextInt(1_000_000);
    }

    private static final class Holder {
        static SecureRandom create() { return new SecureRandom(); }
    }
}
