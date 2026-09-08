package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.function.BiPredicate;

public class Case000534 {
    public Object run(HttpServletRequest request) throws Exception {
        Principal principal = request.getUserPrincipal();
        String authenticatedUser = principal == null ? null : principal.getName();
        String requestedUser = request.getParameter("user");
        if (authenticatedUser == null || !authenticatedUser.equals(requestedUser)) throw new SecurityException("forbidden");
        return loadRecord(requestedUser);
    }

    private String loadRecord(String user) {
        return "record:" + user;
    }
}
