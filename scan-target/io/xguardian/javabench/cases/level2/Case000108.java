package io.xguardian.javabench.cases.level2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

public class Case000108 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        if (engine == null) return null;
        SimpleBindings bindings = new SimpleBindings();
        bindings.put("userValue", value);
        return engine.eval("'prefix:' + String(userValue)", bindings);
    }
}
