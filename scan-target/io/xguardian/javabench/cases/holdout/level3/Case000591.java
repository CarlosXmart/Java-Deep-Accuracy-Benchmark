package io.xguardian.javabench.cases.holdout.level3;

public final class Case000591{
  private Case000591(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^(a+)+$");
    return pattern.matcher(value).matches();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
