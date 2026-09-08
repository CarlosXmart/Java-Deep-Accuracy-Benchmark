package io.xguardian.javabench.cases.calibration.level3;

public final class Case000549{
  private Case000549(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    java.net.URI target=java.net.URI.create(value);
    return target.toURL().openConnection();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
