package io.xguardian.javabench.cases.level3;

import io.xguardian.javabench.support.BenchSupport;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000092 {
    public Object run(DirContext context, String input) throws Exception {
        String value = relay(input);
        String filter = "(uid={0})";
        Object[] args = { value };
        return context.search("ou=people", filter, args, new SearchControls());
    }

    private String relay(String value) {
        return value;
    }
}
