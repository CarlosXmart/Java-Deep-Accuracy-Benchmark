package io.xguardian.javabench.cases.level1;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000003 {
    public Object run(String input) throws Exception {
        Path base = Path.of("/srv/data");
        Path target = Path.of(base.toString(), input);
        return Files.readString(target);
    }
}
