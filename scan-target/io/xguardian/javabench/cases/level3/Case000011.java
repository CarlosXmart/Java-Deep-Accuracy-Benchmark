package io.xguardian.javabench.cases.level3;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000011 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        Path base = Path.of("/srv/data");
        Path target = Path.of(base.toString(), value);
        return Files.readString(target);
    }

    private String relay(String value) {
        return value;
    }
}
