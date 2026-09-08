package io.xguardian.javabench.cases.level5;

import io.xguardian.javabench.support.BenchSupport;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Case000100 {
    public Object run(DirContext context, String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        String filter = "(uid={0})";
        Object[] args = { value };
        return context.search("ou=people", filter, args, new SearchControls());
    }
}
