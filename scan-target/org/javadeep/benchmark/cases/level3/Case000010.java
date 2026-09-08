package org.javadeep.benchmark.cases.level3;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000010 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        Path base = Path.of("/srv/data").toAbsolutePath().normalize();
        Path target = base.resolve(value).normalize();
        if (!target.startsWith(base)) throw new SecurityException("outside base");
        return Files.readString(target);
    }

    private String relay(String value) {
        return value;
    }
}
