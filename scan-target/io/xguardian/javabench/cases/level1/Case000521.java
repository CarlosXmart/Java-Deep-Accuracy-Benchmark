package io.xguardian.javabench.cases.level1;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.function.BiPredicate;

public class Case000521 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        return loadRecord(requestedUser);
    }

    private String loadRecord(String user) {
        return "record:" + user;
    }
}
