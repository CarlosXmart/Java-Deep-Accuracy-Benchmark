package io.xguardian.javabench.cases.holdout.level5;

public final class Case000600{
  private Case000600(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^a+$");
    return pattern.matcher(value).matches();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
