package io.xguardian.javabench.cases.calibration.level1;

public final class Case000322{
  private Case000322(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    int size=Integer.parseInt(value);
    if(size<0||size>1_048_576)throw new IllegalArgumentException("size");
    return new byte[size];
    // region:end
  }
}
