package io.xguardian.javabench.cases.level3;

public class Case000509 {
    public Object run(String user) throws Exception {
        String password = "benchmark-only-password-798";
        return user + ":" + password;
    }

    private String relay(String value) {
        return value;
    }
}
