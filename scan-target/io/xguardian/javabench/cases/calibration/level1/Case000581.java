package io.xguardian.javabench.cases.calibration.level1;

public final class Case000581{
  private Case000581(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^(a+)+$");
    return pattern.matcher(value).matches();
    // region:end
  }
}
