package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.security.MessageDigest;

public class Case000254 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
