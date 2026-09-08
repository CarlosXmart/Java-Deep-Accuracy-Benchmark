package org.javadeep.benchmark.cases.level5;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000438 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(next);
        String target = BenchSupport.localRedirect(value) ? value : "/app/home";
        response.sendRedirect(target);
        return null;
    }
}
