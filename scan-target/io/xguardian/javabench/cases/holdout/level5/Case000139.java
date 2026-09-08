package io.xguardian.javabench.cases.holdout.level5;

public final class Case000139{
  private Case000139(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
