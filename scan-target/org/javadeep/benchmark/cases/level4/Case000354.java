package org.javadeep.benchmark.cases.level4;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Case000354 {
    public Object run(InputStream stream, HttpServletRequest request) throws Exception {
        String value = request.getParameter("fileName");
        String name = BenchSupport.basename(value);
        if (!BenchSupport.allowedUploadName(name)) throw new SecurityException("blocked file type");
        Path target = Path.of("/srv/uploads").resolve(name);
        Files.copy(stream, target, StandardCopyOption.REPLACE_EXISTING);
        return target;
    }
}
