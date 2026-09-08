package io.xguardian.javabench.cases.holdout.level5;

public final class Case000419{
  private Case000419(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.util.logging.Logger.getLogger("Case000419").warning("password="+value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
