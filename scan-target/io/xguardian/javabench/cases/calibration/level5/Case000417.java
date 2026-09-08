package io.xguardian.javabench.cases.calibration.level5;

public final class Case000417{
  private Case000417(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.util.logging.Logger.getLogger("Case000417").warning("password="+value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
