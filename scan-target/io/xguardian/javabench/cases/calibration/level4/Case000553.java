package io.xguardian.javabench.cases.calibration.level4;

public final class Case000553{
  private Case000553(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    java.net.URI target=java.net.URI.create(value);
    return target.toURL().openConnection();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
