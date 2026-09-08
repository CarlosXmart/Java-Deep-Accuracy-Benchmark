package io.xguardian.javabench.cases.calibration.level2;

public final class Case000507{
  private Case000507(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    String password="benchmark-password-123";
    return java.util.Objects.equals(value,password);
    // region:end
  }
}
