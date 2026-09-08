package io.xguardian.javabench.cases.level1;

import java.util.List;

public class Case000021 {
    public Object run(String input) throws Exception {
        return new ProcessBuilder("sh", "-c", "printf %s " + input).start();
    }
}
