package io.xguardian.javabench.cases.calibration.level1;

public final class Case000101{
  private Case000101(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    javax.script.ScriptEngine engine=new javax.script.ScriptEngineManager().getEngineByName("javascript");
    return engine.eval(value);
    // region:end
  }
}
