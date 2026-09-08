package org.javadeep.benchmark.cases.level3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

public class Case000109 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        if (engine == null) return null;
        return engine.eval(value);
    }

    private String relay(String value) {
        return value;
    }
}
