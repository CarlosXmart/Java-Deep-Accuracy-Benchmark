package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.security.MessageDigest;

public class Case000256 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        return digest.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
