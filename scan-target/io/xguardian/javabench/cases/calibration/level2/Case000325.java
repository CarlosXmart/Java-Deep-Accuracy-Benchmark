package io.xguardian.javabench.cases.calibration.level2;

public final class Case000325{
  private Case000325(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    int size=Integer.parseInt(value);
    return new byte[size];
    // region:end
  }
}
