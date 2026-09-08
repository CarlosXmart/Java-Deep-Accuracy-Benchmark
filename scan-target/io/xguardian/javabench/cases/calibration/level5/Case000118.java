package io.xguardian.javabench.cases.calibration.level5;

public final class Case000118{
  private Case000118(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    return Integer.parseInt(value.trim());
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
