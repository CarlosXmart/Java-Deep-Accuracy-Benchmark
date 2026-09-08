package io.xguardian.javabench.cases.calibration.level4;

public final class Case000273{
  private Case000273(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    java.util.Random random=new java.util.Random();
    return value+"-"+random.nextInt(1_000_000);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
