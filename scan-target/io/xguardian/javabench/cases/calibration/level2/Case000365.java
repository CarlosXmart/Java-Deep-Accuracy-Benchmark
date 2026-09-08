package io.xguardian.javabench.cases.calibration.level2;

public final class Case000365{
  private Case000365(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    Class<?> type=Class.forName(value);
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }
}
