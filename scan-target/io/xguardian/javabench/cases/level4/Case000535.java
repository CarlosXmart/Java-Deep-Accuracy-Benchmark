package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000535 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        String record = loadRecord(requestedUser);
        return record;
    }

    private String loadRecord(String user) { return "record:" + user; }
}
