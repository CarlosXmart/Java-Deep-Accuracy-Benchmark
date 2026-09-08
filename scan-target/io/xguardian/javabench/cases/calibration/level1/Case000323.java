package io.xguardian.javabench.cases.calibration.level1;

public final class Case000323{
  private Case000323(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    int size=Integer.parseInt(value);
    return new byte[size];
    // region:end
  }
}
