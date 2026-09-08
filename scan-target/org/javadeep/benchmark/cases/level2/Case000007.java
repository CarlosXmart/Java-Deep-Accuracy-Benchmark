package org.javadeep.benchmark.cases.level2;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000007 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Path base = Path.of("/srv/data");
        Path target = Path.of(base.toString(), value);
        return Files.readString(target);
    }
}
