package io.xguardian.javabench.cases.calibration.level3;

public final class Case000110{
  private Case000110(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    return Integer.parseInt(value.trim());
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
