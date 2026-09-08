package io.xguardian.javabench.cases.calibration.level1;

public final class Case000324{
  private Case000324(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    int size=Integer.parseInt(value);
    if(size<0||size>1_048_576)throw new IllegalArgumentException("size");
    return new byte[size];
    // region:end
  }
}
