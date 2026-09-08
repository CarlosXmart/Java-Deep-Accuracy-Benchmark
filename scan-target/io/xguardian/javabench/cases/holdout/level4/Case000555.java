package io.xguardian.javabench.cases.holdout.level4;

public final class Case000555{
  private Case000555(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    java.net.URI target=java.net.URI.create(value);
    return target.toURL().openConnection();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
