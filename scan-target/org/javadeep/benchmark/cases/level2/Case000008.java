package org.javadeep.benchmark.cases.level2;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000008 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        if (value == null || !value.matches("[A-Za-z0-9._-]{1,64}")) throw new SecurityException("invalid name");
        Path target = Path.of("/srv/data").resolve(value);
        return Files.readString(target);
    }
}
