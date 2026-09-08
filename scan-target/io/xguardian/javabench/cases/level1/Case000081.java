package io.xguardian.javabench.cases.level1;

import io.xguardian.javabench.support.BenchSupport;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000081 {
    public Object run(DirContext context, String input) throws Exception {
        String filter = "(uid=" + input + ")";
        return context.search("ou=people", filter, new SearchControls());
    }
}
