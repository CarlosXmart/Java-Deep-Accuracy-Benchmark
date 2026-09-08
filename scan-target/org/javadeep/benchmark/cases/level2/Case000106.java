package org.javadeep.benchmark.cases.level2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

public class Case000106 {
    public Object run(String input) throws Exception {
        String value = input == null ? "" : input.trim();
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        if (engine == null) return null;
        SimpleBindings bindings = new SimpleBindings();
        bindings.put("userValue", value);
        return engine.eval("String(userValue)", bindings);
    }
}
