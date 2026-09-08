package io.xguardian.javabench.cases.level2;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.function.BiPredicate;

public class Case000525 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        String targetUser = requestedUser;
        return loadRecord(targetUser);
    }

    private String loadRecord(String user) {
        return "record:" + user;
    }
}
