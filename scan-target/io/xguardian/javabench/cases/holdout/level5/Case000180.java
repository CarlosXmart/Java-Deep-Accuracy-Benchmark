package io.xguardian.javabench.cases.holdout.level5;

public final class Case000180{
  private Case000180(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    javax.net.ssl.SSLContext ctx=javax.net.ssl.SSLContext.getDefault();
    return ctx.getSocketFactory();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
