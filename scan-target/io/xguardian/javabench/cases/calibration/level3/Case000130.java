package io.xguardian.javabench.cases.calibration.level3;

public final class Case000130{
  private Case000130(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=relay(input);
    // region:start
    if(value.indexOf('\r')>=0||value.indexOf('\n')>=0)throw new IllegalArgumentException("invalid header");
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
