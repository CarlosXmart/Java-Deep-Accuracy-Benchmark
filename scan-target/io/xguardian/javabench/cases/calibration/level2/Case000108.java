package io.xguardian.javabench.cases.calibration.level2;

public final class Case000108{
  private Case000108(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    return Integer.parseInt(value.trim());
    // region:end
  }
}
