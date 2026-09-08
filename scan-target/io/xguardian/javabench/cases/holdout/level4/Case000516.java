package io.xguardian.javabench.cases.holdout.level4;

public final class Case000516{
  private Case000516(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    String password=System.getenv("BENCHMARK_PASSWORD");
    if(password==null||password.isBlank())throw new IllegalStateException("missing secret");
    return java.util.Objects.equals(value,password);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
