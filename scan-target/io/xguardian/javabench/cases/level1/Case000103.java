package io.xguardian.javabench.cases.level1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

public class Case000103 {
    public Object run(String input) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        if (engine == null) return null;
        return engine.eval("var result = " + input);
    }
}
