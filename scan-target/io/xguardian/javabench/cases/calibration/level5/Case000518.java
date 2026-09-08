package io.xguardian.javabench.cases.calibration.level5;

public final class Case000518{
  private Case000518(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    String password=System.getenv("BENCHMARK_PASSWORD");
    if(password==null||password.isBlank())throw new IllegalStateException("missing secret");
    return java.util.Objects.equals(value,password);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
