package io.xguardian.javabench.cases.calibration.level1;

public final class Case000164{
  private Case000164(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    javax.net.ssl.SSLContext ctx=javax.net.ssl.SSLContext.getDefault();
    return ctx.getSocketFactory();
    // region:end
  }
}
