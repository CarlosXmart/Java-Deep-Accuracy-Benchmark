package io.xguardian.javabench.cases.calibration.level1;

public final class Case000582{
  private Case000582(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^a+$");
    return pattern.matcher(value).matches();
    // region:end
  }
}
