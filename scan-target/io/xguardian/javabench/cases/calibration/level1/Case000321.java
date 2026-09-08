package io.xguardian.javabench.cases.calibration.level1;

public final class Case000321{
  private Case000321(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    int size=Integer.parseInt(value);
    return new byte[size];
    // region:end
  }
}
