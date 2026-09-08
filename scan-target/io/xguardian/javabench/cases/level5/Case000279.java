package io.xguardian.javabench.cases.level5;

import java.security.SecureRandom;
import java.util.Random;

public class Case000279 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        return (long) (Math.random() * 1_000_000_000L);
    }
}
