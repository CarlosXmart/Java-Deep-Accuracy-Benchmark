package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.util.Random;

public class Case000276 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        SecureRandom random = new SecureRandom();
        return random.nextInt(1_000_000);
    }
}
