package io.xguardian.javabench.cases.calibration.level3;

public final class Case000170{
  private Case000170(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    javax.net.ssl.SSLContext ctx=javax.net.ssl.SSLContext.getDefault();
    return ctx.getSocketFactory();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
