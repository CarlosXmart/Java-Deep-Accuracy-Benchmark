package io.xguardian.javabench.cases.calibration.level2;

public final class Case000327{
  private Case000327(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    int size=Integer.parseInt(value);
    return new byte[size];
    // region:end
  }
}
