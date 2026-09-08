package org.javadeep.benchmark.cases.level5;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000020 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        if (value == null || !value.matches("[A-Za-z0-9._-]{1,64}")) throw new SecurityException("invalid name");
        Path target = Path.of("/srv/data").resolve(value);
        return Files.readString(target);
    }
}
