package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;

public class Case000013 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        Path base = Path.of("/srv/data");
        Path target = base.resolve(value);
        return Files.readString(target);
    }
}
