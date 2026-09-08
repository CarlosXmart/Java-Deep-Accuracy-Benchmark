package io.xguardian.javabench.cases.calibration.level3;

public final class Case000589{
  private Case000589(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^(a+)+$");
    return pattern.matcher(value).matches();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
