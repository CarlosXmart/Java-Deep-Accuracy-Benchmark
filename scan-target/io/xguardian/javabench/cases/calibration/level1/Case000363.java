package io.xguardian.javabench.cases.calibration.level1;

public final class Case000363{
  private Case000363(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    Class<?> type=Class.forName(value);
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }
}
