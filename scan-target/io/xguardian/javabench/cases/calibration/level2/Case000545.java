package io.xguardian.javabench.cases.calibration.level2;

public final class Case000545{
  private Case000545(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    java.net.URI target=java.net.URI.create(value);
    return target.toURL().openConnection();
    // region:end
  }
}
