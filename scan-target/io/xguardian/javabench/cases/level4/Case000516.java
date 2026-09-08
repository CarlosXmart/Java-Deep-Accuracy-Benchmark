package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;

public class Case000516 {
    public Object run(String user) throws Exception {
        return System.getProperty("benchmark.external.credential");
    }
}
