package io.xguardian.javabench.cases.calibration.level3;

public final class Case000509{
  private Case000509(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    String password="benchmark-password-123";
    return java.util.Objects.equals(value,password);
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
