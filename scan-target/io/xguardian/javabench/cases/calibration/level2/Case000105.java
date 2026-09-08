package io.xguardian.javabench.cases.calibration.level2;

public final class Case000105{
  private Case000105(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    javax.script.ScriptEngine engine=new javax.script.ScriptEngineManager().getEngineByName("javascript");
    return engine.eval(value);
    // region:end
  }
}
