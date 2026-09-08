package io.xguardian.javabench.cases.calibration.level5;

public final class Case000138{
  private Case000138(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    if(value.indexOf('\r')>=0||value.indexOf('\n')>=0)throw new IllegalArgumentException("invalid header");
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
