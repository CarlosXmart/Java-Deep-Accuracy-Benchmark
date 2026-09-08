package io.xguardian.javabench.cases.calibration.level2;

public final class Case000588{
  private Case000588(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^a+$");
    return pattern.matcher(value).matches();
    // region:end
  }
}
