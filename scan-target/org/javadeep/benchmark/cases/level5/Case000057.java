package org.javadeep.benchmark.cases.level5;

import org.javadeep.benchmark.support.BenchSupport;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Function;

public class Case000057 {
    public Object run(String input, HttpServletResponse response) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(input);
        response.setContentType("text/html");
        response.getWriter().write("<div>" + value + "</div>");
        return null;
    }
}
