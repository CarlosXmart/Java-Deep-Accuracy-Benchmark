package io.xguardian.javabench.cases.calibration.level5;

public final class Case000117{
  private Case000117(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    javax.script.ScriptEngine engine=new javax.script.ScriptEngineManager().getEngineByName("javascript");
    return engine.eval(value);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
