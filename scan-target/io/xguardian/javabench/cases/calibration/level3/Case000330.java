package io.xguardian.javabench.cases.calibration.level3;

public final class Case000330{
  private Case000330(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    int size=Integer.parseInt(value);
    if(size<0||size>1_048_576)throw new IllegalArgumentException("size");
    return new byte[size];
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
