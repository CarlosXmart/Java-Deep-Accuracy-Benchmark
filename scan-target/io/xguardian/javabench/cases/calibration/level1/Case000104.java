package io.xguardian.javabench.cases.calibration.level1;

public final class Case000104{
  private Case000104(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    return Integer.parseInt(value.trim());
    // region:end
  }
}
