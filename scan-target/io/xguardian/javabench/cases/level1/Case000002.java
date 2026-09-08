package io.xguardian.javabench.cases.level1;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000002 {
    public Object run(String input) throws Exception {
        Path base = Path.of("/srv/data").toAbsolutePath().normalize();
        Path target = base.resolve(input).normalize();
        if (!target.startsWith(base)) throw new SecurityException("outside base");
        return Files.readString(target);
    }
}
