package io.xguardian.javabench.cases.holdout.level4;

public final class Case000116{
  private Case000116(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    return Integer.parseInt(value.trim());
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
