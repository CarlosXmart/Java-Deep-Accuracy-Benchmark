package io.xguardian.javabench.cases.level2;

import java.util.List;

public class Case000025 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        return new ProcessBuilder("sh", "-c", "printf %s " + value).start();
    }
}
