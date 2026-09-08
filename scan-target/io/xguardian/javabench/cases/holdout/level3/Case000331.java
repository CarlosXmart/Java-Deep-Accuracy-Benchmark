package io.xguardian.javabench.cases.holdout.level3;

public final class Case000331{
  private Case000331(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    int size=Integer.parseInt(value);
    return new byte[size];
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
