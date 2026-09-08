package io.xguardian.javabench.cases.holdout.level4;

public final class Case000336{
  private Case000336(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    int size=Integer.parseInt(value);
    if(size<0||size>1_048_576)throw new IllegalArgumentException("size");
    return new byte[size];
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
