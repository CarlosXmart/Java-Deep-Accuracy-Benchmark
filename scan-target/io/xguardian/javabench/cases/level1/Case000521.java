package io.xguardian.javabench.cases.level1;

public class Case000521 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        String record = loadRecord(requestedUser);
        return record;
    }

    private String loadRecord(String user) { return "record:" + user; }
}
