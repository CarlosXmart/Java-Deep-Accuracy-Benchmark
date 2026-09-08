package io.xguardian.javabench.cases.calibration.level2;

public final class Case000505{
  private Case000505(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    String password="benchmark-password-123";
    return java.util.Objects.equals(value,password);
    // region:end
  }
}
