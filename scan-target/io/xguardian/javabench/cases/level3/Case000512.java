package io.xguardian.javabench.cases.level3;

public class Case000512 {
    public Object run(String user) throws Exception {
        return System.getProperty("benchmark.external.credential");
    }

    private String relay(String value) {
        return value;
    }
}
