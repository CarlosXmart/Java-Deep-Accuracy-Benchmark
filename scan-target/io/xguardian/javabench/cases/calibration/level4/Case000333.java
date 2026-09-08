package io.xguardian.javabench.cases.calibration.level4;

public final class Case000333{
  private Case000333(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    int size=Integer.parseInt(value);
    return new byte[size];
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
