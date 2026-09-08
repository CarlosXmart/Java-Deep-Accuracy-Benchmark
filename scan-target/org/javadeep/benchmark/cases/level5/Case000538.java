package org.javadeep.benchmark.cases.level5;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.function.BiPredicate;

public class Case000538 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        BiPredicate<String, String> authorized = String::equals;
        if (authenticatedUser == null || !authorized.test(authenticatedUser, requestedUser)) throw new SecurityException("forbidden");
        return loadRecord(requestedUser);
    }

    private String loadRecord(String user) {
        return "record:" + user;
    }
}
