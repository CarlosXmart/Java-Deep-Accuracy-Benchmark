package io.xguardian.javabench.cases.level3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

public class Case000112 {
    public Object run(String input) throws Exception {
        String value = relay(input);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        if (engine == null) return null;
        SimpleBindings bindings = new SimpleBindings();
        bindings.put("userValue", value);
        return engine.eval("'prefix:' + String(userValue)", bindings);
    }

    private String relay(String value) {
        return value;
    }
}
