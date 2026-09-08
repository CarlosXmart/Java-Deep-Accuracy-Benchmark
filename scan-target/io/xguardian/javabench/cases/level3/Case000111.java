package io.xguardian.javabench.cases.level3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

public class Case000111 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        if (engine == null) return null;
        return engine.eval("var result = " + value);
    }

    private String relay(String value) {
        return value;
    }
}
