package org.javadeep.benchmark.cases.level4;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Case000276 {
    public Object run() throws Exception {
        Supplier<SecureRandom> factory = SecureRandom::new;
        return factory.get().nextInt(1_000_000);
    }
}
