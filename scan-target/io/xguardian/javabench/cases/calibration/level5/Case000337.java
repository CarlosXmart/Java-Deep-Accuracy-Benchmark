package io.xguardian.javabench.cases.calibration.level5;

public final class Case000337{
  private Case000337(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    int size=Integer.parseInt(value);
    return new byte[size];
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
