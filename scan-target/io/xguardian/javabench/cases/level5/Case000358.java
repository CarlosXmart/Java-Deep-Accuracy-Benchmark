package io.xguardian.javabench.cases.level5;

import io.xguardian.javabench.support.BenchSupport;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.function.Function;

public class Case000358 {
    public Object run(InputStream stream, String fileName) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(fileName);
        String name = BenchSupport.basename(value);
        if (!BenchSupport.allowedUploadName(name)) throw new SecurityException("blocked file type");
        Path target = Path.of("/srv/uploads").resolve(name);
        Files.copy(stream, target, StandardCopyOption.REPLACE_EXISTING);
        return target;
    }
}
