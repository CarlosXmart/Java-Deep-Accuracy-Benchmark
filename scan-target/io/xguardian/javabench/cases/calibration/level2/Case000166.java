package io.xguardian.javabench.cases.calibration.level2;

public final class Case000166{
  private Case000166(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    javax.net.ssl.SSLContext ctx=javax.net.ssl.SSLContext.getDefault();
    return ctx.getSocketFactory();
    // region:end
  }
}
