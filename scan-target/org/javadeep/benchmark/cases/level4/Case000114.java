package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

public class Case000114 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        if (engine == null) return null;
        SimpleBindings bindings = new SimpleBindings();
        bindings.put("userValue", value);
        return engine.eval("String(userValue)", bindings);
    }
}
