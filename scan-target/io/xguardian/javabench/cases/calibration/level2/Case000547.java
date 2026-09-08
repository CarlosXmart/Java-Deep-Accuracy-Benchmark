package io.xguardian.javabench.cases.calibration.level2;

public final class Case000547{
  private Case000547(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    java.net.URI target=java.net.URI.create(value);
    return target.toURL().openConnection();
    // region:end
  }
}
