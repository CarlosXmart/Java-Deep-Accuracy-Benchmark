package io.xguardian.javabench.cases.level5;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.function.BiPredicate;

public class Case000539 {
    public Object run(String authenticatedUser, String requestedUser) throws Exception {
        BiPredicate<String, String> ignoredAuthorization = String::equals;
        return loadRecord(requestedUser);
    }

    private String loadRecord(String user) {
        return "record:" + user;
    }
}
