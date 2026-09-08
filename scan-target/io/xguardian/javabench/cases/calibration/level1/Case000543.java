package io.xguardian.javabench.cases.calibration.level1;

public final class Case000543{
  private Case000543(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    java.net.URI target=java.net.URI.create(value);
    return target.toURL().openConnection();
    // region:end
  }
}
