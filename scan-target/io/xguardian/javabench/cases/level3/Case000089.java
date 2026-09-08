package io.xguardian.javabench.cases.level3;

import io.xguardian.javabench.support.BenchSupport;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000089 {
    public Object run(DirContext context, String input) throws Exception {
        String value = relay(input);
        String filter = "(uid=" + value + ")";
        return context.search("ou=people", filter, new SearchControls());
    }

    private String relay(String value) {
        return value;
    }
}
