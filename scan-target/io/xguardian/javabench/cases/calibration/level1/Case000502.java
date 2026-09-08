package io.xguardian.javabench.cases.calibration.level1;

public final class Case000502{
  private Case000502(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    String password=System.getenv("BENCHMARK_PASSWORD");
    if(password==null||password.isBlank())throw new IllegalStateException("missing secret");
    return java.util.Objects.equals(value,password);
    // region:end
  }
}
