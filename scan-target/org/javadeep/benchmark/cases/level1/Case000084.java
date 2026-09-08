package org.javadeep.benchmark.cases.level1;

import org.javadeep.benchmark.support.BenchSupport;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000084 {
    public Object run(DirContext context, String input) throws Exception {
        String filter = "(uid={0})";
        Object[] args = { input };
        return context.search("ou=people", filter, args, new SearchControls());
    }
}
