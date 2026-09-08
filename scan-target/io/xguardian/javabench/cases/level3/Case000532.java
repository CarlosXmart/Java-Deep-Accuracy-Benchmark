package io.xguardian.javabench.cases.level3;

public class Case000532 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        if (authenticatedUser == null || !authenticatedUser.equals(requestedUser)) throw new SecurityException("forbidden");
        String record = loadRecord(requestedUser);
        return record;
    }

    private String relay(String value) {
        return value;
    }

    private String loadRecord(String user) { return "record:" + user; }
}
