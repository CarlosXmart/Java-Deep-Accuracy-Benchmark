package io.xguardian.javabench.cases.calibration.level1;

public final class Case000504{
  private Case000504(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    String password=System.getenv("BENCHMARK_PASSWORD");
    if(password==null||password.isBlank())throw new IllegalStateException("missing secret");
    return java.util.Objects.equals(value,password);
    // region:end
  }
}
