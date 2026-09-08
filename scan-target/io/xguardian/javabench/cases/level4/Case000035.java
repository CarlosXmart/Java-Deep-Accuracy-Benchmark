package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class Case000035 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        return Runtime.getRuntime().exec("sh -c echo " + value);
    }
}
