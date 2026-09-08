package io.xguardian.javabench.cases.level5;

public class Case000537 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        String record = loadRecord(requestedUser);
        return record;
    }

    private String loadRecord(String user) { return "record:" + user; }
}
