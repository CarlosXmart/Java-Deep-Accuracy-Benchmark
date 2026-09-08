package io.xguardian.javabench.cases.holdout.level3;

public final class Case000511{
  private Case000511(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    String password="benchmark-password-123";
    return java.util.Objects.equals(value,password);
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
