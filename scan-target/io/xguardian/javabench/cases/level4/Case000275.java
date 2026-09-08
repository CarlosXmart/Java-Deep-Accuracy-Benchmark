package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.util.Random;

public class Case000275 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        return (long) (Math.random() * 1_000_000_000L);
    }
}
