package io.xguardian.javabench.cases.level3;

public class Case000529 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        String record = loadRecord(requestedUser);
        return record;
    }

    private String relay(String value) {
        return value;
    }

    private String loadRecord(String user) { return "record:" + user; }
}
