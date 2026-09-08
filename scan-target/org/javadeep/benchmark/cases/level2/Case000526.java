package org.javadeep.benchmark.cases.level2;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.function.BiPredicate;

public class Case000526 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        String targetUser = requestedUser;
        if (authenticatedUser == null || !authenticatedUser.equals(targetUser)) throw new SecurityException("forbidden");
        return loadRecord(targetUser);
    }

    private String loadRecord(String user) {
        return "record:" + user;
    }
}
