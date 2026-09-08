package io.xguardian.javabench.cases.holdout.level4;

public final class Case000595{
  private Case000595(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^(a+)+$");
    return pattern.matcher(value).matches();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
