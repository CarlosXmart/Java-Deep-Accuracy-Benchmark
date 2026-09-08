package io.xguardian.javabench.cases.holdout.level4;

public final class Case000276{
  private Case000276(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    java.security.SecureRandom random=new java.security.SecureRandom();
    return value+"-"+random.nextInt(1_000_000);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
