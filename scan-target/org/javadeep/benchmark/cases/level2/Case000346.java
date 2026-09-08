package org.javadeep.benchmark.cases.level2;

import org.javadeep.benchmark.support.BenchSupport;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Case000346 {
    public Object run(InputStream stream, String fileName) throws Exception {
        String value = fileName == null ? "" : fileName.trim();
        String name = BenchSupport.basename(value);
        if (!BenchSupport.allowedUploadName(name)) throw new SecurityException("blocked file type");
        Path target = Path.of("/srv/uploads").resolve(name);
        Files.copy(stream, target, StandardCopyOption.REPLACE_EXISTING);
        return target;
    }
}
