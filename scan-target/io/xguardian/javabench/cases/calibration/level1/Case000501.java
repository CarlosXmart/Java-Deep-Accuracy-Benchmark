package io.xguardian.javabench.cases.calibration.level1;

public final class Case000501{
  private Case000501(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    String password="benchmark-password-123";
    return java.util.Objects.equals(value,password);
    // region:end
  }
}
