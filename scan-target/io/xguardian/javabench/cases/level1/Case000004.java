package io.xguardian.javabench.cases.level1;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000004 {
    public Object run(String input) throws Exception {
        if (input == null || !input.matches("[A-Za-z0-9._-]{1,64}")) throw new SecurityException("invalid name");
        Path target = Path.of("/srv/data").resolve(input);
        return Files.readString(target);
    }
}
