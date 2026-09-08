package io.xguardian.javabench.cases.calibration.level3;

public final class Case000109{
  private Case000109(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    javax.script.ScriptEngine engine=new javax.script.ScriptEngineManager().getEngineByName("javascript");
    return engine.eval(value);
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
