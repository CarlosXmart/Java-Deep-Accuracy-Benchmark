package io.xguardian.javabench.cases.calibration.level3;

public final class Case000369{
  private Case000369(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    Class<?> type=Class.forName(value);
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
