package io.xguardian.javabench.cases.level3;

public class Case000031 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        return Runtime.getRuntime().exec(new String[] {"sh", "-c", "echo " + value});
    }

    private String relay(String value) {
        return value;
    }
}
