package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class Case000033 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        return new ProcessBuilder("sh", "-c", "printf %s " + value).start();
    }
}
