package io.xguardian.javabench.cases.level3;

import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

public class Case000392 {
    public Object run(InputStream input) throws Exception {
        byte[] bytes = input.readNBytes(4096);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private String relay(String value) {
        return value;
    }
}
