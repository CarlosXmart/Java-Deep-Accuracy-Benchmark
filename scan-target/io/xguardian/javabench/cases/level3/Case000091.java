package io.xguardian.javabench.cases.level3;

import io.xguardian.javabench.support.BenchSupport;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000091 {
    public Object run(DirContext context, String input) throws Exception {
        String value = relay(input);
        String filter = "(&(objectClass=person)(cn=" + value + "))";
        return context.search("ou=people", filter, new SearchControls());
    }

    private String relay(String value) {
        return value;
    }
}
