package io.xguardian.javabench.cases.holdout.level3;

public final class Case000172{
  private Case000172(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    javax.net.ssl.SSLContext ctx=javax.net.ssl.SSLContext.getDefault();
    return ctx.getSocketFactory();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
