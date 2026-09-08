package io.xguardian.javabench.cases.level3;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000272 {
    public Object run() throws Exception {
        return strongRandom().nextInt(1_000_000);
    }

    private SecureRandom strongRandom() { return new SecureRandom(); }
}
