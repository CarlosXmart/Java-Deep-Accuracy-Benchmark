package io.xguardian.javabench.cases.holdout.level3;

public final class Case000332{
  private Case000332(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    int size=Integer.parseInt(value);
    if(size<0||size>1_048_576)throw new IllegalArgumentException("size");
    return new byte[size];
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
