package io.xguardian.javabench.cases.holdout.level3;

public final class Case000551{
  private Case000551(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    java.net.URI target=java.net.URI.create(value);
    return target.toURL().openConnection();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
