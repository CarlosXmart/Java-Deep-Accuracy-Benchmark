package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000514 {
    public Object run(String user) throws Exception {
        String password = System.getenv("SERVICE_PASSWORD");
        if (password == null) throw new IllegalStateException("credential unavailable");
        return user + ":" + password;
    }
}
