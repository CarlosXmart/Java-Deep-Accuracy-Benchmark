package io.xguardian.javabench.cases.calibration.level4;

public final class Case000513{
  private Case000513(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    String password="benchmark-password-123";
    return java.util.Objects.equals(value,password);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
