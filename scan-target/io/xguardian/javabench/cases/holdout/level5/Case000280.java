package io.xguardian.javabench.cases.holdout.level5;

public final class Case000280{
  private Case000280(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.security.SecureRandom random=new java.security.SecureRandom();
    return value+"-"+random.nextInt(1_000_000);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
