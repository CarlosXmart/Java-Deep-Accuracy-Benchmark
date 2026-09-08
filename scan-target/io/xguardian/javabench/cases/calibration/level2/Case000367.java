package io.xguardian.javabench.cases.calibration.level2;

public final class Case000367{
  private Case000367(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    Class<?> type=Class.forName(value);
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }
}
