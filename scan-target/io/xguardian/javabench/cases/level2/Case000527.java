package io.xguardian.javabench.cases.level2;

public class Case000527 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        String record = loadRecord(requestedUser);
        return record;
    }

    private String loadRecord(String user) { return "record:" + user; }
}
