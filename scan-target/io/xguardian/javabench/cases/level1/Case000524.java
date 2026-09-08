package io.xguardian.javabench.cases.level1;

public class Case000524 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        if (authenticatedUser == null || !authenticatedUser.equals(requestedUser)) throw new SecurityException("forbidden");
        String record = loadRecord(requestedUser);
        return record;
    }

    private String loadRecord(String user) { return "record:" + user; }
}
