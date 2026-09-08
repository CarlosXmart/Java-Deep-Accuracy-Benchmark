package io.xguardian.javabench.cases.holdout.level5;

public final class Case000520{
  private Case000520(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    String password=System.getenv("BENCHMARK_PASSWORD");
    if(password==null||password.isBlank())throw new IllegalStateException("missing secret");
    return java.util.Objects.equals(value,password);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
