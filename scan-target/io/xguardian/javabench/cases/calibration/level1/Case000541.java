package io.xguardian.javabench.cases.calibration.level1;

public final class Case000541{
  private Case000541(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    java.net.URI target=java.net.URI.create(value);
    return target.toURL().openConnection();
    // region:end
  }
}
