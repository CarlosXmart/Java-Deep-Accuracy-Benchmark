package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000534 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        if (authenticatedUser == null || !authenticatedUser.equals(requestedUser)) throw new SecurityException("forbidden");
        String record = loadRecord(requestedUser);
        return record;
    }

    private String loadRecord(String user) { return "record:" + user; }
}
