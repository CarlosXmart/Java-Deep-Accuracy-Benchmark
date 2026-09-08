package org.javadeep.benchmark.cases.level1;

import org.javadeep.benchmark.support.BenchSupport;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Case000341 {
    public Object run(InputStream stream, String fileName) throws Exception {
        String name = BenchSupport.basename(fileName);
        Path target = Path.of("/srv/uploads").resolve(name);
        Files.copy(stream, target, StandardCopyOption.REPLACE_EXISTING);
        return target;
    }
}
