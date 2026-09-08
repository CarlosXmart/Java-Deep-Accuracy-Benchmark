package io.xguardian.javabench.cases.calibration.level3;

public final class Case000329{
  private Case000329(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    int size=Integer.parseInt(value);
    return new byte[size];
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
