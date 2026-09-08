package io.xguardian.javabench.cases.calibration.level4;

public final class Case000413{
  private Case000413(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    java.util.logging.Logger.getLogger("Case000413").warning("password="+value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
