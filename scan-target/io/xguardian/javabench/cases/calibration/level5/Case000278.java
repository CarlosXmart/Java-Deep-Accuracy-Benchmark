package io.xguardian.javabench.cases.calibration.level5;

public final class Case000278{
  private Case000278(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.security.SecureRandom random=new java.security.SecureRandom();
    return value+"-"+random.nextInt(1_000_000);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
