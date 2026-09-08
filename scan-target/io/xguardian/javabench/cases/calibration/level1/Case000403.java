package io.xguardian.javabench.cases.calibration.level1;

public final class Case000403{
  private Case000403(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    java.util.logging.Logger.getLogger("Case000403").warning("password="+value);
    return null;
    // region:end
  }
}
