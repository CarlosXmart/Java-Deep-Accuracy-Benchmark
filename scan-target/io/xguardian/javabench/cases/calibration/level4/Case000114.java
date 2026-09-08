package io.xguardian.javabench.cases.calibration.level4;

public final class Case000114{
  private Case000114(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    return Integer.parseInt(value.trim());
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
