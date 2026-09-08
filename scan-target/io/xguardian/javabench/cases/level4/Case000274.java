package io.xguardian.javabench.cases.level4;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000274 {
    public Object run() throws Exception {
        Supplier<SecureRandom> factory = SecureRandom::new;
        return factory.get().nextLong();
    }
}
