package org.javadeep.benchmark.cases.level5;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000018 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Path base = Path.of("/srv/data").toAbsolutePath().normalize();
        Path target = base.resolve(value).normalize();
        if (!target.startsWith(base)) throw new SecurityException("outside base");
        return Files.readString(target);
    }
}
