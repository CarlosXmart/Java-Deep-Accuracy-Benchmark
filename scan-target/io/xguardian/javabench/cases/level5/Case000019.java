package io.xguardian.javabench.cases.level5;

import java.nio.file.Files;
import java.nio.file.Path;

public class Case000019 {
    public Object run(String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Path base = Path.of("/srv/data");
        String reduced = value.replace("../", "");
        Path target = base.resolve(reduced);
        return Files.readString(target);
    }
}
