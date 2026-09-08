package io.xguardian.javabench.cases.calibration.level4;

public final class Case000113{
  private Case000113(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    javax.script.ScriptEngine engine=new javax.script.ScriptEngineManager().getEngineByName("javascript");
    return engine.eval(value);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
