package io.xguardian.javabench.cases.calibration.level1;

public final class Case000503{
  private Case000503(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    String password="benchmark-password-123";
    return java.util.Objects.equals(value,password);
    // region:end
  }
}
