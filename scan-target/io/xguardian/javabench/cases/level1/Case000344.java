package io.xguardian.javabench.cases.level1;

import io.xguardian.javabench.support.BenchSupport;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Case000344 {
    public Object run(InputStream stream, String fileName) throws Exception {
        String name = BenchSupport.basename(fileName);
        if (!BenchSupport.allowedUploadName(name)) throw new SecurityException("blocked file type");
        Path target = Path.of("/srv/uploads").resolve(name);
        Files.copy(stream, target, StandardCopyOption.REPLACE_EXISTING);
        return target;
    }
}
