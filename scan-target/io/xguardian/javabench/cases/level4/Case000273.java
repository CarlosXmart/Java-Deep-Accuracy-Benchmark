package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.util.Random;

public class Case000273 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        return new Random().nextLong();
    }
}
