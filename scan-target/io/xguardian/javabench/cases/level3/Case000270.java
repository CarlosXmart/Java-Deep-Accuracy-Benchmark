package io.xguardian.javabench.cases.level3;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000270 {
    public Object run() throws Exception {
        return strongRandom().nextLong();
    }

    private SecureRandom strongRandom() { return new SecureRandom(); }
}
