package io.xguardian.javabench.cases.level2;

import io.xguardian.javabench.support.BenchSupport;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Case000347 {
    public Object run(InputStream stream, String fileName) throws Exception {
        String value = fileName == null ? "" : fileName.trim();
        String name = BenchSupport.basename(value);
        Path target = Path.of("/srv/uploads").resolve(name);
        Files.copy(stream, target, StandardCopyOption.REPLACE_EXISTING);
        return target;
    }
}
