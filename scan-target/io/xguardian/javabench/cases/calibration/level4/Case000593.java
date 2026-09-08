package io.xguardian.javabench.cases.calibration.level4;

public final class Case000593{
  private Case000593(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^(a+)+$");
    return pattern.matcher(value).matches();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
