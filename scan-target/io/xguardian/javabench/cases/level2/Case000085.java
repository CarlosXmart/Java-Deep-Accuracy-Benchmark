package io.xguardian.javabench.cases.level2;

import io.xguardian.javabench.support.BenchSupport;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000085 {
    public Object run(DirContext context, String input) throws Exception {
        String value = input == null ? "" : input.trim();
        String filter = "(uid=" + value + ")";
        return context.search("ou=people", filter, new SearchControls());
    }
}
