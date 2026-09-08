package io.xguardian.javabench.cases.calibration.level3;

public final class Case000510{
  private Case000510(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    String password=System.getenv("BENCHMARK_PASSWORD");
    if(password==null||password.isBlank())throw new IllegalStateException("missing secret");
    return java.util.Objects.equals(value,password);
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
