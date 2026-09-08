package io.xguardian.javabench.cases.calibration.level2;

public final class Case000586{
  private Case000586(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^a+$");
    return pattern.matcher(value).matches();
    // region:end
  }
}
