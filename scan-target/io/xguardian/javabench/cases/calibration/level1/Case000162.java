package io.xguardian.javabench.cases.calibration.level1;

public final class Case000162{
  private Case000162(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    javax.net.ssl.SSLContext ctx=javax.net.ssl.SSLContext.getDefault();
    return ctx.getSocketFactory();
    // region:end
  }
}
