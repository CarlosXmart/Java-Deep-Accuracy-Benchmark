package io.xguardian.javabench.cases.level5;

import io.xguardian.javabench.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000440 {
    public Object run(String next, HttpServletResponse response) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(next);
        String target = BenchSupport.localRedirect(value) ? value : "/app/home";
        response.sendRedirect(target);
        return null;
    }
}
