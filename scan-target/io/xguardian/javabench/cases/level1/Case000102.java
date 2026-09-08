package io.xguardian.javabench.cases.level1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

public class Case000102 {
    public Object run(String input) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        if (engine == null) return null;
        SimpleBindings bindings = new SimpleBindings();
        bindings.put("userValue", input);
        return engine.eval("String(userValue)", bindings);
    }
}
