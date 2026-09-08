package org.javadeep.benchmark.cases.level3;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000009 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        Path base = Path.of("/srv/data");
        Path target = base.resolve(value);
        return Files.readString(target);
    }

    private String relay(String value) {
        return value;
    }
}
