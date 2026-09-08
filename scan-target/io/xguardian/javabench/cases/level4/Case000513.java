package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000513 {
    public Object run(String user) throws Exception {
        String password = "benchmark-only-password-798";
        return user + ":" + password;
    }
}
