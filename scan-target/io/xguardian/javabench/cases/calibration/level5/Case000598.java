package io.xguardian.javabench.cases.calibration.level5;

public final class Case000598{
  private Case000598(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^a+$");
    return pattern.matcher(value).matches();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
