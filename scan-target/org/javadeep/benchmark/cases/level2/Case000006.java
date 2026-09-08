package org.javadeep.benchmark.cases.level2;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000006 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Path base = Path.of("/srv/data").toAbsolutePath().normalize();
        Path target = base.resolve(value).normalize();
        if (!target.startsWith(base)) throw new SecurityException("outside base");
        return Files.readString(target);
    }
}
