package io.xguardian.javabench.cases.level1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000263 {
    public Object run() throws Exception {
        return (long) (Math.random() * 1_000_000_000L);
    }
}
