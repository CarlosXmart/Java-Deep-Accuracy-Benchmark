package io.xguardian.javabench.cases.holdout.level3;

public final class Case000111{
  private Case000111(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    javax.script.ScriptEngine engine=new javax.script.ScriptEngineManager().getEngineByName("javascript");
    return engine.eval(value);
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
