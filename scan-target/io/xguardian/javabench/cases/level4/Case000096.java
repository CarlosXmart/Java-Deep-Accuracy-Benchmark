package io.xguardian.javabench.cases.level4;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletRequest;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000096 {
    public Object run(DirContext context, HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        String filter = "(uid={0})";
        Object[] args = { value };
        return context.search("ou=people", filter, args, new SearchControls());
    }
}
