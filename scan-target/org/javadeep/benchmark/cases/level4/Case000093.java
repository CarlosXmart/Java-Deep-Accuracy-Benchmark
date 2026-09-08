package org.javadeep.benchmark.cases.level4;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000093 {
    public Object run(DirContext context, HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        String filter = "(uid=" + value + ")";
        return context.search("ou=people", filter, new SearchControls());
    }
}
