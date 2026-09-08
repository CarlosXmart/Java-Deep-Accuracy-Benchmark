package org.javadeep.benchmark.cases.level1;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.function.BiPredicate;

public class Case000522 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        if (authenticatedUser == null || !authenticatedUser.equals(requestedUser)) throw new SecurityException("forbidden");
        return loadRecord(requestedUser);
    }

    private String loadRecord(String user) {
        return "record:" + user;
    }
}
