package io.xguardian.javabench.cases.level2;

public class Case000506 {
    public Object run(String user) throws Exception {
        String password = System.getenv("SERVICE_PASSWORD");
        if (password == null) throw new IllegalStateException("credential unavailable");
        return user + ":" + password;
    }
}
