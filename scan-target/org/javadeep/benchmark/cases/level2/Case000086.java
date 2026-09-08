package org.javadeep.benchmark.cases.level2;

import org.javadeep.benchmark.support.BenchSupport;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000086 {
    public Object run(DirContext context, String input) throws Exception {
        String value = input == null ? "" : input.trim();
        String filter = "(uid=" + BenchSupport.ldapFilterEncode(value) + ")";
        return context.search("ou=people", filter, new SearchControls());
    }
}
