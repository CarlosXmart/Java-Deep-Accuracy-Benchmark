package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;

public class Case000016 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        if (value == null || !value.matches("[A-Za-z0-9._-]{1,64}")) throw new SecurityException("invalid name");
        Path target = Path.of("/srv/data").resolve(value);
        return Files.readString(target);
    }
}
