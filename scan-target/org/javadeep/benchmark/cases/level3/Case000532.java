package org.javadeep.benchmark.cases.level3;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.function.BiPredicate;

public class Case000532 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        authorize(authenticatedUser, requestedUser);
        return loadRecord(requestedUser);
    }

    private String loadRecord(String user) {
        return "record:" + user;
    }

    private void authorize(String authenticatedUser, String requestedUser) {
        if (authenticatedUser == null || !authenticatedUser.equals(requestedUser)) throw new SecurityException("forbidden");
    }
}
