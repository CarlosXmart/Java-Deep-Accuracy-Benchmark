package io.xguardian.javabench.cases.calibration.level5;

public final class Case000338{
  private Case000338(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    int size=Integer.parseInt(value);
    if(size<0||size>1_048_576)throw new IllegalArgumentException("size");
    return new byte[size];
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
