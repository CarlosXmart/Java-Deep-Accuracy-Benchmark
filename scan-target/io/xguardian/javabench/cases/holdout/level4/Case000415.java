package io.xguardian.javabench.cases.holdout.level4;

public final class Case000415{
  private Case000415(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    java.util.logging.Logger.getLogger("Case000415").warning("password="+value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
