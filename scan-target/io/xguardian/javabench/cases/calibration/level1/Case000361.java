package io.xguardian.javabench.cases.calibration.level1;

public final class Case000361{
  private Case000361(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    Class<?> type=Class.forName(value);
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }
}
