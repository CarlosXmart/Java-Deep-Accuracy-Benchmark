package io.xguardian.javabench.cases.holdout.level4;

public final class Case000375{
  private Case000375(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    Class<?> type=Class.forName(value);
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
