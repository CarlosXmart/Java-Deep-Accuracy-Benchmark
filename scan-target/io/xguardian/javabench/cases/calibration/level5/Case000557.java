package io.xguardian.javabench.cases.calibration.level5;

public final class Case000557{
  private Case000557(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.net.URI target=java.net.URI.create(value);
    return target.toURL().openConnection();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
