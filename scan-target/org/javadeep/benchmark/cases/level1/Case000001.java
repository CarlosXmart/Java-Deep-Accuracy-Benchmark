package org.javadeep.benchmark.cases.level1;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000001 {
    public Object run(String input) throws Exception {
        Path base = Path.of("/srv/data");
        Path target = base.resolve(input);
        return Files.readString(target);
    }
}
